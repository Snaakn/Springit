package de.pkrause.springit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.pkrause.springit.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    public Optional<User> findByEmail(String str);
}
