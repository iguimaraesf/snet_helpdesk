package com.schoolofnet.helpdesk.service;

import com.schoolofnet.helpdesk.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthUserUtil {
    public static UserDetails create(User user) {
        return new CustomUserPrincipal(user);
    }
}
