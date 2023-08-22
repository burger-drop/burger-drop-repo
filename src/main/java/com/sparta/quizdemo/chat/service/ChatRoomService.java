package com.sparta.quizdemo.chat.service;

import com.sparta.quizdemo.common.entity.ChatRoom;
import com.sparta.quizdemo.common.entity.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatRoomService {
    // 채팅방(topic)에 발행되는 메시지를 처리할 Listner
    private final RedisMessageListenerContainer redisMessageListener;

    // 구독 처리 서비스
    private final RedisSubscriber redisSubscriber;
    private static final String CHAT_ROOMS = "CHAT_ROOM";

    private final RedisTemplate<String, String> redisTemplate;

    // 채팅방의 대화 메시지를 발행하기 위한 redis topic 정보. 서버별로 채팅방에 매치되는 topic정보를 Map에 넣어 roomId로 찾을수 있도록 한다.
    private Map<String, ChannelTopic> topics;

    @PostConstruct
    private void init() {
        topics = new HashMap<>();
    }

    /* 채팅방 생성 및 입장 */
    public ChatRoom createAndEnterChatRoom(User user) {
        String username = user.getUsername();
        String chatUser = (String) redisTemplate.opsForHash().get(CHAT_ROOMS, username);

        if (chatUser != null) {
            // 이미 해당 user의 채팅방이 Redis에 존재하면 입장
            enterChatRoom(chatUser);

            log.info("chatRoomId : " + chatUser);
            return new ChatRoom(chatUser, username);
        } else {
            // 채팅방이 존재하지 않는 경우에만 생성
            ChatRoom chatRoom = ChatRoom.create(user);

            // 채팅방을 Redis에 저장
            redisTemplate.opsForHash().put(CHAT_ROOMS, chatRoom.getUsername(), chatRoom.getRoomId());

            // 채팅방에 입장
            enterChatRoom(chatRoom.getUsername());

            log.info("ChatRoomId : " + chatRoom.getRoomId());
            log.info("user : " + chatRoom.getUsername());
            return chatRoom;
        }
    }

    /* chatRoom List */
    public List<String> findAllRooms() {
        return redisTemplate.execute((RedisCallback<List<String>>) connection -> {
            List<String> chatRooms = new ArrayList<>();
            Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan(CHAT_ROOMS, ScanOptions.NONE);
            while (cursor.hasNext()) {
                Map.Entry<Object, Object> entry = cursor.next();
                chatRooms.add("user : " + entry.getKey().toString() + ", roomId : " + entry.getValue().toString());
            }
            return chatRooms;
        });
    }

    /* chatRoom 단권 조회 */
    public String findRoomByUser(String username) {
        String chatUser = (String) redisTemplate.opsForHash().get(CHAT_ROOMS, username);
        return chatUser != null ? "user : " + username + "\nroomId : " + chatUser : null;
    }

    /* 채팅방 나가기 */
    public void deleteChatRoom(String username) {
        redisTemplate.opsForHash().delete(CHAT_ROOMS, username);
    }

    public void enterChatRoom(String username) {
        // Redis에서 해당 채팅방의 토픽을 가져옴
        ChannelTopic topic = getTopic(username);

        if (topic == null) {
            // 토픽이 없는 경우 새로 생성하고 메시지 리스너 추가
            topic = new ChannelTopic(username);
            redisMessageListener.addMessageListener(redisSubscriber, topic);
            topics.put(username, topic);
        }
    }

    public ChannelTopic getTopic(String roomId) {
        return topics.get(roomId);
    }
}
