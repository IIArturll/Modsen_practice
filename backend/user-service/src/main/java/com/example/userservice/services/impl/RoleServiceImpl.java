package com.example.userservice.services.impl;

import com.example.userservice.entities.RoleEntity;
import com.example.userservice.repository.RoleRepository;
import com.example.userservice.services.RoleService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public RoleEntity save(String role) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRole(role);

        return repository.save(roleEntity);
    }

    @Override
    public RoleEntity update(Integer id, String role) {
        RoleEntity roleEntity = repository.findById(id).get();
        roleEntity.setRole(role);

        return repository.save(roleEntity);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public RoleEntity getById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public RoleEntity getByRole(String role) {
        return repository.findByRole(role).get();
    }

    @Override
    public Iterable<RoleEntity> getAll() {
        return repository.findAll();
    }
}
