package edu.ci.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

/**
 * @création 01/07/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.entity
 */

@Entity
@Table(name = "enseignants")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enseignant {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("enseignant")
    private List<Cours> cours;
}
