package de.pkrause.springit.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
@NoArgsConstructor
public class Vote {

    @Id @GeneratedValue
    private Long id;
    private int vote;


    // user
    // link
    
}
