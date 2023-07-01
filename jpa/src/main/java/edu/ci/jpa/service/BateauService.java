package edu.ci.jpa.service;

import edu.ci.jpa.dto.AddBateauRequest;
import edu.ci.jpa.dto.UpdateBateauRequest;
import edu.ci.jpa.entity.Bateau;
import edu.ci.jpa.repository.BateauRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @création 23/06/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.service
 */

//@RequiredArgsConstructor
@Service
public class BateauService {

    private final BateauRepository bateauRepository;

    public BateauService(BateauRepository bateauRepository) {
        this.bateauRepository = bateauRepository;
    }

    public void addBateau(AddBateauRequest dto){
        Bateau savedBateau = bateauRepository
                .save(Bateau
                        .builder()
                        .nom(dto.getNom())
                        .capacite(dto.getCapacite())
                        .couleur(dto.getCouleur())
                        .equipage(dto.getEquipage())
                        .build());
    }

    @Transactional
    public void updateBateau(UpdateBateauRequest dto){
        Bateau bateau = bateauRepository.findById(dto.getId())
                .orElseThrow(()
                        -> new IllegalArgumentException("Invalid ID"));
        bateau.setCapacite(dto.getCapacite());
        bateau.setEquipage(dto.getEquipage());
    }
    @Transactional
    public void updateBateauV2(UpdateBateauRequest dto){
        bateauRepository.updateBatau(dto.getId(), dto.getCapacite(), dto.getEquipage());
    }

    public List<Bateau> getAll(){
        return bateauRepository.findAll();
    }

    public void deleteBateau(Long id){
        bateauRepository.deleteById(id);
    }

    public Bateau getOne(Long id){
        return bateauRepository.findById(id).orElseThrow(() -> new RuntimeException("L'id rechercher n'existe pas"));
    }
}
