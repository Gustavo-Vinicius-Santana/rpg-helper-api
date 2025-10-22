package br.com.rpg_tools.rpg_helper_api.controller;

import br.com.rpg_tools.rpg_helper_api.dto.CampaignRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CampaignResponseDTO;
import br.com.rpg_tools.rpg_helper_api.service.CampaignService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaigns")
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping
    public ResponseEntity<CampaignResponseDTO> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignResponseDTO> findById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<CampaignResponseDTO> findByName(@PathVariable("name") String name) {
        return null;
    }

    @PostMapping
    public ResponseEntity<CampaignResponseDTO> save(
            @Valid @RequestBody CampaignRequestDTO campaignRequest
    ) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampaignResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody CampaignRequestDTO campaignRequest
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {

    }
}
