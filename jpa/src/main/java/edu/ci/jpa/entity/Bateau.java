package edu.ci.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

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
@NoArgsConstructor
@AllArgsConstructor
public class Bateau {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero")
    private Long id;

    @Column(name = "nom")
    private String nom;

    private Integer capacite;

    private Integer equipage;

    private String couleur;

    @OneToOne(mappedBy = "bateau")
    @JsonIgnoreProperties("bateau")
    private Commandant commandant;
}
