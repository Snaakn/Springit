package de.pkrause.springit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.NonNull;



@Entity
@Data
@NoArgsConstructor
public class Comment {

    @Id @GeneratedValue
    @NonNull
    private Long id;
    @NonNull
    private String body;

    // link
    
}
