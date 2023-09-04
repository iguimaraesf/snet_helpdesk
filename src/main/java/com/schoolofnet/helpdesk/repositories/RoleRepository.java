package com.schoolofnet.helpdesk.repositories;

import com.schoolofnet.helpdesk.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
