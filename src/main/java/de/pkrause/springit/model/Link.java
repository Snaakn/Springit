package de.pkrause.springit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity 
@Data
@NoArgsConstructor
public class Link {

    @Id 
    @GeneratedValue
    @EqualsAndHashCode.Include 
    private Long id;
    
    @NonNull
    private String title;
    
    @NonNull
    private String url;
   
    
    // comments

    
}
