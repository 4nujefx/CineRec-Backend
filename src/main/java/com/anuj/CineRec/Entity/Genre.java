package com.anuj.CineRec.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    @OneToMany(mappedBy = "genre",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Movies> movies;

}
