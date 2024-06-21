package com.example.userservice.security;

import com.example.userservice.core.enums.Status;
import com.example.userservice.entities.RoleEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class MyUserDetails implements UserDetails {
    private Integer id;
    private String email;
    private String password;
    private RoleEntity role;
    private Status status;

    public MyUserDetails() {
    }

    public MyUserDetails(Integer id, String email, String password, RoleEntity role, Status status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return status == Status.DEACTIVATED;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status == Status.DEACTIVATED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return status == Status.ACTIVATED;
    }
}
