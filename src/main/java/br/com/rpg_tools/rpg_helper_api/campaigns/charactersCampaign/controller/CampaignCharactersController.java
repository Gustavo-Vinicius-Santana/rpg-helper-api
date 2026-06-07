package br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.controller;

import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.dto.CampaignCharactersRequestDTO;
import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.dto.CampaignCharactersResponseDTO;
import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.service.CampaignCharactersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaign-characters")
@RequiredArgsConstructor
public class CampaignCharactersController {
    private final CampaignCharactersService campaignCharactersService;

    @GetMapping
    public ResponseEntity<Page<CampaignCharactersResponseDTO>> findAll(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pagination
    ) {
        return ResponseEntity.ok(campaignCharactersService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignCharactersResponseDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(campaignCharactersService.findById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Page<CampaignCharactersResponseDTO>> findByName(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pagination,
            @PathVariable("name") String name
    ) {
        return ResponseEntity.ok(campaignCharactersService.findByName(name, pagination));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampaignCharactersResponseDTO> save(
            @Valid @RequestBody CampaignCharactersRequestDTO campaignCharacters
    ) {
        CampaignCharactersResponseDTO saveCharacter = campaignCharactersService.save(campaignCharacters);
        return ResponseEntity.ok(saveCharacter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampaignCharactersResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody CampaignCharactersRequestDTO campaignCharacters
    ) {
        CampaignCharactersResponseDTO characterUpdate = campaignCharactersService.update(id, campaignCharacters);
        return ResponseEntity.ok(characterUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        campaignCharactersService.deleteId(id);
        return ResponseEntity.noContent().build();
    }
}
