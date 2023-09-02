package com.sparta.quizdemo.sse.dto;

import com.sparta.quizdemo.sse.entity.Notification;
import com.sparta.quizdemo.sse.entity.NotificationContent;
import com.sparta.quizdemo.sse.entity.RelatedURL;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class NotificationResponseDto {
    private Long id;
    private String content;
    private String url;
    private Boolean status;

    public static NotificationResponseDto create(Notification notification) {
        return new NotificationResponseDto(notification.getId(),
                notification.getContent(),
                notification.getUrl(),
                notification.getIsRead());
    }
}