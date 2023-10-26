package de.pkrause.springit.repository;

import de.pkrause.springit.model.Link;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LinkRepository extends JpaRepository<Link, Long> {

    
    Link findByTitle(String title);

    List<Link> findAllByOrderByIdAsc();
    List<Link> findAllByOrderByVoteCountDesc();

    
}
