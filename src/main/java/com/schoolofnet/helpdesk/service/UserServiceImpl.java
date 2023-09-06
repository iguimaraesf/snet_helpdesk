package com.schoolofnet.helpdesk.service;

import com.schoolofnet.helpdesk.model.User;
import com.schoolofnet.helpdesk.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, User user) {
        var res = repository.findById(id).orElseThrow();
        repository.save(res);
    }
}
