package edu.ci.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

/**
 * @création 01/07/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.entity
 */

@Entity
@Table(name = "cours")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cours {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String libelle;
    private Integer nbHeure;
    @ManyToOne
    @JoinColumn(name = "id_ens")
    @JsonIgnoreProperties("cours")
    private Enseignant enseignant;
}
