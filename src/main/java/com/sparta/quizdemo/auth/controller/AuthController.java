package com.sparta.quizdemo.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.quizdemo.auth.service.GoogleService;
import com.sparta.quizdemo.auth.service.KakaoService;
import com.sparta.quizdemo.auth.service.NaverService;
import com.sparta.quizdemo.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final NaverService naverService;
    private final KakaoService kakaoService;
    private final GoogleService googleService;
    private final JwtUtil jwtUtil;

    @GetMapping("/naver/login")
    public RedirectView naverLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {

        String token = naverService.naverLogin(code);
        jwtUtil.addJwtToCookie(token, response);
        return new RedirectView("/");
    }

    @GetMapping("/kakao/login")
    public RedirectView kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {

        String token = kakaoService.kakaoLogin(code);
        jwtUtil.addJwtToCookie(token, response);
        return new RedirectView("/");
    }

    @GetMapping("/google/login")
    public RedirectView googleLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {

        String token = googleService.googleLogin(code);
        jwtUtil.addJwtToCookie(token, response);

        return new RedirectView("/");
    }
}
