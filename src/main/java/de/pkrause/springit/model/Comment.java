package de.pkrause.springit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString.Exclude;



@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Comment extends Auditable{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String body;

    // link
    @ManyToOne
    @NonNull
    @Exclude
    private Link link;
    
}
