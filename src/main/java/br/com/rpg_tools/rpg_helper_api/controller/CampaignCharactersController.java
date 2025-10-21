package br.com.rpg_tools.rpg_helper_api.controller;

import br.com.rpg_tools.rpg_helper_api.dto.CampaignCharactersRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CampaignCharactersResponseDTO;
import br.com.rpg_tools.rpg_helper_api.service.CampaignCharactersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaign-characters")
@RequiredArgsConstructor
public class CampaignCharactersController {
    private final CampaignCharactersService campaignCharactersService;

    @GetMapping
    public ResponseEntity<CampaignCharactersResponseDTO> findAll(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignCharactersResponseDTO> findById(@PathVariable("id") Long id){
        return null;
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<CampaignCharactersResponseDTO> findByName(@PathVariable("name") String name){
        return null;
    }

    @PostMapping
    public ResponseEntity<CampaignCharactersResponseDTO> save(@Valid
        @RequestBody CampaignCharactersRequestDTO campaignCharacters
    ){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampaignCharactersResponseDTO> update(@Valid
        @PathVariable("id") long id,
        @RequestBody CampaignCharactersRequestDTO campaignCharacters
    ){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){

    }
}
