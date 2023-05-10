package de.pkrause.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import de.pkrause.springit.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    
}
