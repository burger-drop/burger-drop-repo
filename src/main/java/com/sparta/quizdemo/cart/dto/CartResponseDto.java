package com.sparta.quizdemo.cart.dto;

import com.sparta.quizdemo.cart.entity.Cart;
import com.sparta.quizdemo.user.entity.User;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CartResponseDto {
    private String username;
    private Long cartId;
    private Long totalPrice;
    private String deliveryMethod = "배달을 선택할 경우 2000원 추가";
    private Long totalCookingTime;
    private List<CartItemResponseDto> cartItemList;

    public CartResponseDto(User user, Cart cart, Long totalPrice, Long totalCookingTime) {
        this.username = user.getUsername();
        this.cartId = cart.getId();
        this.totalPrice = totalPrice;
        this.totalCookingTime = totalCookingTime;
        this.cartItemList = cart.getCartItemList().stream().map(CartItemResponseDto::new).collect(Collectors.toList());
    }
}
