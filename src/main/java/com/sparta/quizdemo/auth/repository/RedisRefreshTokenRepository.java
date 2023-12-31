package com.sparta.quizdemo.auth.repository;

import com.sparta.quizdemo.config.RedisConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanCursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisRefreshTokenRepository {

    private final RedisTemplate<String, String> redisTemplate;
    private final long expirationTimeSeconds; // refreshToken 만료 시간
    //Redis 관련 설정을 초기화
    public RedisRefreshTokenRepository(
            RedisTemplate<String, String> redisTemplate,
            @Value("${refresh.token.expiration.seconds}") long expirationTimeSeconds) {
        this.redisTemplate = redisTemplate;
        this.expirationTimeSeconds = expirationTimeSeconds;
    }

    //일반 로그인 시 리프레시 토큰 저장, +구글
    public void generateRefreshToken(String username) {
        String refreshToken = UUID.randomUUID().toString()+":refresh";
        redisTemplate.opsForValue().set(refreshToken, username, expirationTimeSeconds, TimeUnit.SECONDS);
    }

    //네이버, 카카오 로그인 시 리프레시 토큰 저장
    public String generateRefreshTokenInSocial(String refreshToken, String username) {

        redisTemplate.opsForValue().set(refreshToken, username, expirationTimeSeconds, TimeUnit.SECONDS);
        return refreshToken;
    }

    //username을 기준으로 리프레시 토큰을 찾으면서 유효한지까지 판별
    public Optional<String> findValidRefreshTokenByUsername(String username) {

        ScanOptions options = ScanOptions.scanOptions().match("*:refresh").count(100).build();
        Cursor<String> refreshTokenKeys = redisTemplate.scan(options);

        while (refreshTokenKeys.hasNext()) {
                String refreshToken = refreshTokenKeys.next();
                String storedUsername = redisTemplate.opsForValue().get(refreshToken);

                // 리프레시 토큰의 유저네임과 매칭되는 유저네임 찾기
                if (storedUsername != null && storedUsername.equals(username)) {
                    // 여전히 리프레시 토큰이 유효한지 판별, 유효하면 토큰 리턴, 유효하지않으면 재로그인요청
                    if (isRefreshTokenValid(refreshToken)) {
                        return Optional.of(refreshToken);
                    } else {
                        // 리프레시 토큰이 만료되었다면 삭제
                        deleteRefreshToken(refreshToken);
                    }
                }

        }

        refreshTokenKeys.close();

        return Optional.empty();
    }


    //리프레시 토큰 유효성 검사
    public boolean isRefreshTokenValid(String refreshToken) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(refreshToken));
    }

    //리프레시 토큰 삭제 (로그아웃 시)
    public void deleteRefreshToken(String username) {

        ScanOptions options = ScanOptions.scanOptions().match("*:refresh").count(100).build();
        Cursor<String> refreshTokenKeys = redisTemplate.scan(options);

        while (refreshTokenKeys.hasNext()) {
            String refreshToken = refreshTokenKeys.next();
            String storedUsername = redisTemplate.opsForValue().get(refreshToken);

            // 리프레시 토큰의 유저네임과 매칭되는 유저네임 찾기
            if (storedUsername != null && storedUsername.equals(username)) {

                redisTemplate.delete(refreshToken);

            }


        }

        refreshTokenKeys.close();
    }



    //리프레시 토큰 조회
    public Optional<String> findByUsername(String username) {
        String refreshToken = redisTemplate.opsForValue().get(username);
        return Optional.ofNullable(refreshToken);
    }
}