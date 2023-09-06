package com.schoolofnet.helpdesk.repositories;

import com.schoolofnet.helpdesk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
