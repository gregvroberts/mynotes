package com.greg.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greg.mynotes.models.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long> {
    Notes findbyTitle(final String Title);
}