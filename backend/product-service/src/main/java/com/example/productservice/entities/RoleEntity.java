package com.example.productservice.entities;

import com.example.productservice.core.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(schema = "modsen", name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RoleEntity {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Role role;

    public RoleEntity(Role role) {
        this.role = role;
        this.id = (int) (role.ordinal() + 1);
    }

    public void setRole(Role role) {
        this.role = role;
        this.id = (int) (role.ordinal() + 1);
    }
}
