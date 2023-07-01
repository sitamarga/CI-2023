package edu.ci.jpa.controller;

import edu.ci.jpa.dto.AddCommandantRequest;
import edu.ci.jpa.service.CommandantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @création 01/07/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.controller
 */

@RestController
@RequestMapping("/api/v1/commandant")
@RequiredArgsConstructor
public class CommandantController {

    private final CommandantService commandantService;

    @PostMapping("/save")
    public void addCommandant(@RequestBody AddCommandantRequest dto){
        commandantService.addCommandant(dto);
    }
}
