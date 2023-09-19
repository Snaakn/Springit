package de.pkrause.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.pkrause.springit.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
