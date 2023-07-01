package edu.ci.jpa.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @création 01/07/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.dto
 */

@Data
@Builder
public class AddBateauRequest {

    private String nom;
    private Integer capacite;
    private Integer equipage;
    private String couleur;
}
