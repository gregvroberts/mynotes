package com.greg.mynotes.repositories;

/**
 *
 * Created by Gregory Roberts on 5/27/21
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import com.greg.mynotes.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(final String email);
}