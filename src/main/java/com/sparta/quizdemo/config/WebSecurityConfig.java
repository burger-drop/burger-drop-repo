package com.sparta.quizdemo.config;

import com.sparta.quizdemo.auth.repository.RedisRefreshTokenRepository;
import com.sparta.quizdemo.backoffice.service.BackofficeService;
import com.sparta.quizdemo.common.security.JwtAuthenticationFilter;
import com.sparta.quizdemo.common.security.JwtAuthorizationFilter;
import com.sparta.quizdemo.common.security.UserDetailsServiceImpl;
import com.sparta.quizdemo.util.JwtUtil;
import com.sparta.quizdemo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity // Spring Security 지원을 가능하게 함
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig implements WebMvcConfigurer {

    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final BackofficeService backofficeService;
    private final UserService userService;
    private final RedisRefreshTokenRepository redisRefreshTokenRepository;
    //private final TokenLogoutHandler tokenLogoutHandler;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter(jwtUtil, redisRefreshTokenRepository);
        filter.setAuthenticationManager(authenticationManager(authenticationConfiguration));
        return filter;
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter() {
        return new JwtAuthorizationFilter(jwtUtil, userDetailsService, redisRefreshTokenRepository, userService);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // CSRF 설정
        http.csrf((csrf) -> csrf.disable());

        // 기본 설정인 Session 방식은 사용하지 않고 JWT 방식을 사용하기 위한 설정
        http.sessionManagement((sessionManagement) ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.authorizeHttpRequests((authorizeHttpRequests) ->
                authorizeHttpRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // resources 접근 허용 설정
                        .requestMatchers("/api/user/**").permitAll() // '/api/user/'로 시작하는 요청 모두 접근 허가
                        .requestMatchers("/api/user/info/password","/user/info/password").permitAll()
                        .requestMatchers("/api/user/info/username","/user/info/username").permitAll()
                        .requestMatchers("/app/chat/**").permitAll()
                        .requestMatchers("/api/chat/saveMessages/**", "/api/chat/getMessages/**", "/api/notifications/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/comments/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/product").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/product/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/product/**").permitAll()
                        .requestMatchers("/", "/login","/signup","/api/mail","/api/auth/**","/api/user/**", "/v3/api-docs/**", "/swagger-ui/**").permitAll()

                        .anyRequest().authenticated() // 그 외 모든 요청 인증처리
        );

//        //로그 아웃
//        http.logout((logout ->
//                logout.logoutUrl("/api/auth/logout")
//                        .invalidateHttpSession(true)
//                        .deleteCookies("Authorization")
//                        .addLogoutHandler(tokenLogoutHandler)
//                        .logoutSuccessHandler((request, response, authentication) -> {
//                            // 아무런 응답을 하지 않도록 처리
//                        })));


        // 필터 관리
        http.addFilterBefore(jwtAuthorizationFilter(), JwtAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        // 인증되지 않은 사용자가 localhost:8080에 접근했을 때 로그인 페이지로 리디렉션되도록 설정
        //사용시 Authorization필터를 계속 거치는 문제 발생
//        http.exceptionHandling((exceptionHandling) ->
//                exceptionHandling.authenticationEntryPoint((request, response, authException) -> {
//                    response.sendRedirect("/main/login");
//                })
//        );

        // 접근 불가 페이지
        /*http.exceptionHandling((exceptionHandling) ->
                exceptionHandling
                        // "접근 불가" 페이지 URL 설정
                        .accessDeniedPage("/forbidden.html")
        );*/

        return http.build();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(backofficeService)
                .addPathPatterns("/api/**");
    }
}