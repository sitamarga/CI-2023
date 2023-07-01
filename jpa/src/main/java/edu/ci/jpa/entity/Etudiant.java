package edu.ci.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @création 01/07/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.entity
 */
@Entity
@Table(name = "etudiants")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String matricule;
    private String nom;
    private String prenom;
    @ManyToMany
    @JoinTable(name = "etudiant_matires",
    joinColumns = @JoinColumn(name = "id_etud"),
    inverseJoinColumns = @JoinColumn(name = "id_mat"))
    private List<Matiere> matieres;
}
