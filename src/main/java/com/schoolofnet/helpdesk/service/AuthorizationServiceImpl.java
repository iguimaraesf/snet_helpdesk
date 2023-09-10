package com.schoolofnet.helpdesk.service;

import com.schoolofnet.helpdesk.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var u = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User %s not found.".formatted(username)));
        return AuthUserUtil.create(u);
    }
}
