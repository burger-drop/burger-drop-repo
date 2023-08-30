package com.sparta.quizdemo.comment.dto;


import com.sparta.quizdemo.comment.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
//    private Long user_id;
    private String nickname;
    private String content;
    private int likeCnt;
    private boolean bool;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
//        this.user_id = comment.getUser().getId();
        this.nickname = comment.getUser().getNickname();
        this.content = comment.getContent();
        this.likeCnt = comment.getLikeCnt();
        this.bool = comment.isBool();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}