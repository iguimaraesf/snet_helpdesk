package com.schoolofnet.helpdesk.service;

import com.schoolofnet.helpdesk.model.Role;
import com.schoolofnet.helpdesk.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role create(Role role) {
        return this.repository.save(role);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
