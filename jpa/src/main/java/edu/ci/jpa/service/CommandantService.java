package edu.ci.jpa.service;

import edu.ci.jpa.dto.AddCommandantRequest;
import edu.ci.jpa.entity.Bateau;
import edu.ci.jpa.entity.Commandant;
import edu.ci.jpa.repository.CommandantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @création 01/07/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.service
 */

@Service
@RequiredArgsConstructor
public class CommandantService {

    private final CommandantRepository commandantRepository;

    public void addCommandant(AddCommandantRequest dto){
        Commandant commandant = Commandant
                .builder()
                .name(dto.getNom())
                .bateau(Bateau.builder()
                        .nom(dto.getBateau().getNom())
                        .capacite(dto.getBateau().getCapacite())
                        .equipage(dto.getBateau().getEquipage())
                        .couleur(dto.getBateau().getCouleur())
                        .build())
                .build();
        commandantRepository.save(commandant);
    }
}
