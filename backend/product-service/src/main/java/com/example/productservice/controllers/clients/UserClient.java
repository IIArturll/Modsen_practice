package com.example.productservice.controllers.clients;

import com.example.productservice.entities.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(value = "user-service", path = "micro/user")
public interface UserClient {
    @GetMapping("/email/{email}")
    ResponseEntity<Optional<UserEntity>> getByEmail(@PathVariable("email") String email);

    @GetMapping("/login/{login}")
    ResponseEntity<Optional<UserEntity>> getByLogin(@PathVariable("login") String login);
}
