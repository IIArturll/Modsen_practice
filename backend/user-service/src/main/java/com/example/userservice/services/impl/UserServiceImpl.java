package com.example.userservice.services.impl;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.mappers.UserEntityMapper;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.exceptions.NotFoundException;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.services.UserService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public UserDTO save(UserEntity userEntity) {
        userRepository.save(userEntity);
        return userEntityMapper.toDto(userEntity);
    }

    @Override
    public UserDTO update(Integer id, UserDTO userDto) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can`t find user with ID: " + id));

        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getById(Integer id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can`t find user with ID: " + id));
        return userEntityMapper.toDto(userEntity);
    }

    @Override
    public UserDTO getByLogin(String login) {
        UserEntity userEntity = userRepository.findByLogin(login)
                .orElseThrow(() -> new NotFoundException("Can`t find user with login: " + login));
        return userEntityMapper.toDto(userEntity);
    }

    @Override
    public UserDTO getByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Can`t find user with email: " + email));
        return userEntityMapper.toDto(userEntity);
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (var userEntity : userRepository.findAll()) {
            userDTOList.add(userEntityMapper.toDto(userEntity));
        }
        if (userDTOList.isEmpty()) { throw new NotFoundException("Can`t find any users"); }
        return userDTOList;
    }
}
