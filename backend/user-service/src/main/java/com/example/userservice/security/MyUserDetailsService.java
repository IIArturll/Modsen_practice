package com.example.userservice.security;

import com.example.userservice.core.mappers.UserMapper;
import com.example.userservice.exceptions.NotFoundException;
import com.example.userservice.services.UserMicroService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    private final UserMicroService service;
    private final UserMapper userMapper;

    public MyUserDetailsService(UserMicroService service, UserMapper mapper) {
        this.service = service;
        this.userMapper = mapper;
    }

    @Override
    public MyUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userMapper.userEntityToMyUserDetails(service.getByEmail(email)
                .orElseThrow(() -> new NotFoundException("User with this email not found")));
    }

    public MyUserDetails loadUserByLogin(String login) throws UsernameNotFoundException {
        return userMapper.userEntityToMyUserDetails(service.getByLogin(login)
                .orElseThrow(() -> new NotFoundException("User with this login not found")));

    }
}
