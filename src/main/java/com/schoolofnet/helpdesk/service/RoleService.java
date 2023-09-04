package com.schoolofnet.helpdesk.service;

import com.schoolofnet.helpdesk.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role create(Role role);
    void delete(Long id);
}
