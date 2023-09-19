package de.pkrause.springit.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import io.micrometer.core.lang.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Role {
    
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NonNull @NotEmpty
    private String name;

    @ManyToMany( mappedBy = "roles" )
    private Collection<User> users;

}
