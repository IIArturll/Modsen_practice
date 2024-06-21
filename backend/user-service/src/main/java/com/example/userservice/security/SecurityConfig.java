package com.example.userservice.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        // Позволяет получать запросы с других источников
        http.cors(AbstractHttpConfigurer::disable);
        // Откл. стандартной формы для входа
        http.formLogin(AbstractHttpConfigurer::disable);

        // Каждый запрос выполняется без сессий
        http.sessionManagement(sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        // Точка аутентификации для неавторизованных запросов
//        http.exceptionHandling((exceptionHandling) ->
//                exceptionHandling.authenticationEntryPoint((
//                        (request, response, authException) ->
//                                response.setStatus(HttpServletRes.SC_UNAUTHORIZED))));

        // Точка аутентификации для запрещенных запросов
//        http.exceptionHandling(exceptionHandling ->
//                exceptionHandling.accessDeniedHandler((
//                        (request, response, accessDeniedException) ->
//                                response.setStatus(HttpServletResponse.SC_FORBIDDEN))));

        return http.build();
    }
}
