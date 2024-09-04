package com.example.userservice.services.impl;

import com.example.userservice.core.dto.UserCreateDTO;
import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.dto.UserLoginDTO;
import com.example.userservice.core.enums.Role;
import com.example.userservice.core.enums.Status;
import com.example.userservice.core.mappers.UserMapper;
import com.example.userservice.entities.RefreshTokenEntity;
import com.example.userservice.entities.RoleEntity;
import com.example.userservice.entities.StatusEntity;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.exceptions.BadRequestException;
import com.example.userservice.exceptions.InvalidPasswordException;
import com.example.userservice.exceptions.NotFoundException;
import com.example.userservice.exceptions.UserAlreadyExistsException;
import com.example.userservice.core.dto.AuthDTO;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.security.MyUserDetails;
import com.example.userservice.security.MyUserDetailsService;
import com.example.userservice.security.jwt.JwtTokenUtil;
import com.example.userservice.services.RefreshTokenService;
import com.example.userservice.services.UserService;
import org.mapstruct.control.MappingControl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final String emailValidationPattern = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    private final String loginValidationPattern = "^[a-zA-Z]+$";
    private final MyUserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;
    private final RefreshTokenService refreshTokenService;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper,
                           PasswordEncoder passwordEncoder, MyUserDetailsService userDetailsService,
                           JwtTokenUtil jwtTokenUtil, RefreshTokenService refreshTokenService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    public void register(UserCreateDTO userDto) {
        if (userRepository.findByEmail(userDto.email()).isPresent()) {
            throw new UserAlreadyExistsException("User already exist with email: " + userDto.email());
        } else if (userRepository.findByLogin(userDto.login()).isPresent()) {
            throw new UserAlreadyExistsException("User already exist with login: " + userDto.login());
        }
        UserEntity user = new UserEntity();
        user.setName(userDto.name());
        user.setSurname(userDto.surname());
        user.setEmail(userDto.email());
        user.setLogin(userDto.login());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setRole(new RoleEntity(Role.USER));
        user.setStatus(new StatusEntity(Status.ACTIVATED)); //todo verification by email
        user.setSex(userDto.sex());
        user.setDateOfBirth(userDto.dateOfBirth());
        userRepository.save(user);

    }

    @Override
    public AuthDTO login(UserLoginDTO user) {
        String userIdentifier = user.getIdentifier();
        UserEntity entity;
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
            RefreshTokenEntity refreshToken = refreshTokenService.generateRefreshToken(entity);
            return new AuthDTO(jwtTokenUtil.generateAccessToken(userDetails), refreshToken.getToken().toString());
        } else {
            throw new InvalidPasswordException("Invalid password");
        }
    }

    @Override
    public AuthDTO refreshToken(AuthDTO authDTO) {
        String email = jwtTokenUtil.getUsername(authDTO.getAccessToken());
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException("user with email: " + email + " not found"));
        MyUserDetails userDetails = userDetailsService.loadUserByUsername(email);
        RefreshTokenEntity refreshTokenEntity = refreshTokenService.
                checkRefreshToken(userEntity, authDTO.getRefreshToken());
        return new AuthDTO(jwtTokenUtil.generateAccessToken(userDetails),
                refreshTokenEntity.getToken().toString());
    }

    @Override
    public void update(UserCreateDTO userDto) {
        UserEntity userEntity = getAuthorizedUser();
        //todo email verification if email was changed
        userEntity.setEmail(userDto.email());
        userEntity.setLogin(userDto.login());
        userEntity.setName(userDto.name());
        userEntity.setSurname(userDto.surname());
        userEntity.setPassword(passwordEncoder.encode(userDto.password()));
        userEntity.setSex(userDto.sex());
        userEntity.setDateOfBirth(userDto.dateOfBirth());
        userRepository.save(userEntity);
    }

    @Override
    public void delete() {
        UserEntity userEntity = getAuthorizedUser();
        userRepository.delete(userEntity);
    }

    @Override
    public UserDTO getUserInfo() {
        UserEntity userEntity = getAuthorizedUser();
        return userMapper.toDto(userEntity);
    }

    private UserEntity getAuthorizedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("Not authenticated");
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        return userRepository.findByEmail(username).orElseThrow(
                () -> new NotFoundException("Can't find user with email: " + username));

    }
}


