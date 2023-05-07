package de.pkrause.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.pkrause.springit.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
