package edu.ci.jpa.service;

import edu.ci.jpa.entity.Bateau;
import edu.ci.jpa.repository.BateauRepository;

import java.util.List;

/**
 * @création 23/06/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.service
 */

//@RequiredArgsConstructor
public class BateauService {

    private final BateauRepository bateauRepository;

    public BateauService(BateauRepository bateauRepository) {
        this.bateauRepository = bateauRepository;
    }

    public void addBateau(String nom){
        Bateau savedBateau = bateauRepository.save(Bateau.builder().name(nom).build());
    }

    public List<Bateau> getAll(){
        return bateauRepository.findAll();
    }

    public Bateau getOne(Long id){
        return bateauRepository.findById(id).orElseThrow(() -> new RuntimeException("L'id rechercher n'existe pas"));
    }
}
