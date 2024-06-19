package com.example.userservice.security;

import com.example.userservice.core.mappers.UserMapper;
import com.example.userservice.exceptions.NotFoundException;
import com.example.userservice.services.UserMicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    private final UserMicroService service;

    public MyUserDetailsService(UserMicroService service) {
        this.service = service;
    }

    @Override
    public MyUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return UserMapper.convertToUserDetails(service.getByEmail(email)
                .orElseThrow(() -> new NotFoundException("User with this email not found")));
    }

}
