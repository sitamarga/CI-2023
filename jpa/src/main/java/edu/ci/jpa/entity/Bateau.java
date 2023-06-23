package edu.ci.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @création 23/06/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.entity
 */

@Table(name = "bateaux")
@Data
@Entity
@Builder
public class Bateau {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero")
    private Long id;

    @Column(name = "nom")
    private String name;

    @OneToOne(mappedBy = "bateau")
    @JsonIgnoreProperties("bateau")
    private Commandant commandant;
}
