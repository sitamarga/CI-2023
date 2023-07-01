package edu.ci.jpa.controller;

import edu.ci.jpa.dto.AddBateauRequest;
import edu.ci.jpa.dto.UpdateBateauRequest;
import edu.ci.jpa.entity.Bateau;
import edu.ci.jpa.service.BateauService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @création 01/07/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.controller
 */


@RestController
@RequestMapping("/api/v1/bateau")
@RequiredArgsConstructor
public class BateauController {

    private final BateauService bateauService;

    @PostMapping("/save")
    public void addBateau(@RequestBody AddBateauRequest dto){
        bateauService.addBateau(dto);
    }
    @PutMapping("/update")
    public void updateBateau(@RequestBody UpdateBateauRequest dto){
        bateauService.updateBateauV2(dto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBateau(@PathVariable("id") Long id){
        bateauService.deleteBateau(id);
    }

    @GetMapping("/all")
    public List<Bateau> getAll(){
        List<Bateau> bateaus = bateauService.getAll();
        return bateaus;
    }
}
