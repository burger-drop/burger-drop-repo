package com.sparta.quizdemo.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SocialUserInfoDto {
    private String id;
    private String username;
    private String email;
    private String nickname;
    private String phone;
    private String social;
    public SocialUserInfoDto(String id, String username, String email, String nickname, String phone, String social) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.social = social;
    }

    public SocialUserInfoDto(String id, String username, String email, String nickname, String social) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.social = social;
    }

    // email을 username으로 하기로 해서 변경

}