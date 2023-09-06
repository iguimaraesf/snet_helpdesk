package com.schoolofnet.helpdesk.service;

import com.schoolofnet.helpdesk.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User create(User user);
    void delete(Long id);
    void update(Long id, User user);
    User show(Long id);
}
