package com.example.userservice.core.mappers;

import com.example.userservice.entities.UserEntity;
import com.example.userservice.security.MyUserDetails;

public class UserMapper {
    public static MyUserDetails convertToUserDetails(UserEntity e) {
        return new MyUserDetails(e.getId(), e.getEmail(), e.getPassword(),
                e.getRole(), "WHAT ABOUT STATUS?");
    }
}
