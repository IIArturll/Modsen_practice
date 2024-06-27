package com.example.userservice.security;


import com.example.userservice.security.jwt.JwtFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.protocol.HTTP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.RequestContextFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter, RequestContextFilter requestContextFilter) throws Exception {
        // Позволяет получать запросы с других источников
        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);
        // Откл. стандартной формы для входа
        http.formLogin(AbstractHttpConfigurer::disable);

        // Каждый запрос выполняется без сессий
        http.sessionManagement(sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        // Точка аутентификации для неавторизованных запросов
        http.exceptionHandling((exceptionHandling) ->
                exceptionHandling.authenticationEntryPoint((
                        (request, response, authException) ->
                                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED))));

//         Точка аутентификации для запрещенных запросов
        http.exceptionHandling(exceptionHandling ->
                exceptionHandling.accessDeniedHandler((
                        (request, response, accessDeniedException) ->
                                response.setStatus(HttpServletResponse.SC_FORBIDDEN))));


        http
                .authorizeHttpRequests(auth -> auth
//                                .requestMatchers("/micro/**").access(
//                                        new WebExpressionAuthorizationManager("hasIpAddress('product-service')")) //для докера
//                                .requestMatchers("/micro/**").access(
//                                        new WebExpressionAuthorizationManager("hasIpAddress('order-service')")) //для докера
                                .requestMatchers("/micro/**").permitAll() //для тетсов на локалке
                                .requestMatchers(HttpMethod.POST, "/api/v1/user/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/v1/user/register").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/v1/user/refresh").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/api/v1/user").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/user").authenticated()
                                .requestMatchers(HttpMethod.GET, "/api/v1/user").authenticated()
                                .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
                                .anyRequest().denyAll()
                );
        http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
