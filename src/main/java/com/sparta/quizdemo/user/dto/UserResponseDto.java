package com.sparta.quizdemo.user.dto;

import com.sparta.quizdemo.comment.dto.CommentResponseDto;
import com.sparta.quizdemo.common.entity.UserRoleEnum;
import com.sparta.quizdemo.order.dto.OrderResponseDto;
import com.sparta.quizdemo.user.entity.User;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserResponseDto {
    private String username;
    private String nickname;
    private UserRoleEnum role;
    private String zip_code;
    private String address1;
    private String address2;
    private String email;
    private Long orderCount;
    private List<OrderResponseDto> orderList;
    private List<CommentResponseDto> commentList;
    private String social;
    //댓글 내역 조회

    public UserResponseDto(User user) {
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.role = user.getRole();
        this.zip_code = user.getAddress().getZip_code();
        this.address1 = user.getAddress().getAddress1();
        this.address2 = user.getAddress().getAddress2();
        this.email = user.getEmail();
        this.orderCount = user.getOrderCount();
        this.orderList = user.getOrderList().stream().map(OrderResponseDto::new).collect(Collectors.toList());
        this.commentList = user.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
        this.social = user.getSocial();
    }
}
