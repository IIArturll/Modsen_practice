package com.example.orderservice.security;


import com.example.orderservice.security.jwt.JwtFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);

        http.sessionManagement(sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        http.exceptionHandling((exceptionHandling) ->
                exceptionHandling.authenticationEntryPoint((
                        (request, response, authException) ->
                                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED))));

        http.exceptionHandling(exceptionHandling ->
                exceptionHandling.accessDeniedHandler((
                        (request, response, accessDeniedException) ->
                                response.setStatus(HttpServletResponse.SC_FORBIDDEN))));


        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/v1/order/").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/v1/order/").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/order/all").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/v1/order/all/*").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/order/*").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/order/*").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/order/*").hasRole("ADMIN")
                        .anyRequest().denyAll()
                );
        http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
