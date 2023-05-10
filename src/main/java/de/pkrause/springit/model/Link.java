package de.pkrause.springit.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Link extends Auditable {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String url;

    // comments
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();

}
