package com.schoolofnet.helpdesk.service;

import com.schoolofnet.helpdesk.model.User;
import com.schoolofnet.helpdesk.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, User user) {
        var existent = show(id);
        existent.setName(user.getName());
        existent.setEmail(user.getEmail());
        existent.setLastName(user.getLastName());
        existent.setPassword(encoder.encode(user.getPassword()));
        existent.setActive(user.getActive());
        repository.save(existent);
    }

    @Override
    public User show(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
