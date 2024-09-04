package com.example.orderservice.security;

import com.example.orderservice.controllers.clients.UserClient;
import com.example.orderservice.core.exceptions.NotFoundException;
import com.example.orderservice.core.mappers.UserMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    private final UserClient client;
    private final UserMapper userMapper;

    public MyUserDetailsService(UserClient client, UserMapper mapper) {
        this.client = client;
        this.userMapper = mapper;
    }

    @Override
    public MyUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MyUserDetails myUserDetails = userMapper.userEntityToMyUserDetails(client.getByEmail(email).getBody()
                .orElseThrow(() -> new NotFoundException("User with this email not found")));
        return myUserDetails;
    }

    public MyUserDetails loadUserByLogin(String login) throws UsernameNotFoundException {
        return userMapper.userEntityToMyUserDetails(client.getByLogin(login).getBody()
                .orElseThrow(() -> new NotFoundException("User with this login not found")));

    }
}
