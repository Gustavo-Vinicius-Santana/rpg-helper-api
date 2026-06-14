package br.com.rpg_tools.rpg_helper_api.campaigns.campaign.controller;

import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.dto.CampaignRequestDTO;
import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.dto.CampaignResponseDTO;
import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.service.CampaignService;
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
@RequestMapping("/campaigns")
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping
    public ResponseEntity<Page<CampaignResponseDTO>> findAll(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pagination
    ) {
        return ResponseEntity.ok(campaignService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(campaignService.findById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Page<CampaignResponseDTO>> findByName(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pagination,
            @PathVariable("name") String name
    ) {
        return ResponseEntity.ok(campaignService.findByName(name, pagination));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampaignResponseDTO> save(
            @Valid @RequestBody CampaignRequestDTO campaignRequest
    ) {
        CampaignResponseDTO saveCampaign = campaignService.save(campaignRequest);

        return ResponseEntity.ok(saveCampaign);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampaignResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody CampaignRequestDTO campaignRequest
    ) {
        CampaignResponseDTO campaignUpdate = campaignService.update(id, campaignRequest);

        return ResponseEntity.ok(campaignUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        campaignService.deleteId(id);

        return ResponseEntity.noContent().build();
    }
}
