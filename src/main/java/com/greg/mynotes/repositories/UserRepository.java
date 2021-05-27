package com.greg.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greg.mynotes.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(final String email);
}