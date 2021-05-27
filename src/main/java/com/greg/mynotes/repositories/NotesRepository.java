package com.greg.mynotes.repositories;

/**
 *
 * Created by Gregory Roberts on 5/27/21
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import com.greg.mynotes.models.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long> {
    Notes findbyTitle(final String Title);
}