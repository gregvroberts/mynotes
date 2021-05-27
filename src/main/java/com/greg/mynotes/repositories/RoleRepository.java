package com.greg.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greg.mynotes.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(final String role);
}