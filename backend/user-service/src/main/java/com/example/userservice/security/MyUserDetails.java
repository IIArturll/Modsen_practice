package com.example.userservice.security;

import com.example.userservice.core.enums.Role;
import com.example.userservice.core.enums.Status;
import com.example.userservice.entities.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MyUserDetails implements UserDetails {
    private Integer id;
    private String email;
    private String login;
    private String password;
    private Role role;
    private Status status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority("ROLE_" + role));
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
