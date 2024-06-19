package com.example.userservice.services.impl;

import com.example.userservice.core.dto.UserLoginDTO;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.exceptions.BadRequestException;
import com.example.userservice.exceptions.InvalidPasswordException;
import com.example.userservice.exceptions.NotFoundException;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.security.MyUserDetails;
import com.example.userservice.security.MyUserDetailsService;
import com.example.userservice.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MyUserDetailsService userDetailsService;
    private final String emailValidationPattern = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    private final String loginValidationPattern = "^[a-zA-Z]+$";

    @Override
    public String login(UserLoginDTO user) {
        String userIdentifier = user.getIdentifier();
        UserEntity entity = new UserEntity();
        if (userIdentifier.matches(emailValidationPattern)) {
            entity = userRepository.findByEmail(userIdentifier).orElseThrow(
                    () -> new NotFoundException("user with email: " + user.getIdentifier() + " not found"));
        } else if (userIdentifier.matches(loginValidationPattern)) {
            entity = userRepository.findByLogin(userIdentifier).orElseThrow(
                    () -> new NotFoundException("user with login: " + user.getIdentifier() + " not found"));
        } else {
            throw new BadRequestException("incorrect format of login/email");
        }
        if (passwordEncoder.matches(user.getPassword(), entity.getPassword())) {
            MyUserDetails userDetails = userDetailsService.loadUserByUsername(entity.getEmail());
            return tokenUtil.generateToken(userDetails);
        } else {
            throw new InvalidPasswordException("Invalid password");
        }
    }
}
