package com.greg.mynotes.repositories;

/**
 *
 * Created by Gregory Roberts on 5/27/21
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import com.greg.mynotes.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(final String role);
}