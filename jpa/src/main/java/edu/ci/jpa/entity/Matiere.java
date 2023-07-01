package edu.ci.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @création 01/07/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.entity
 */
@Entity
@Table(name = "matieres")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private Integer nbHeure;
}
