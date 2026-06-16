package br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.controller;

import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.dto.CombatParticipantsRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.dto.CombatParticipantsResponseDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.ParticipantType;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.service.CombatParticipantsService;
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
@RequestMapping("/combat-participants")
@RequiredArgsConstructor
public class CombatParticipantsController {

    private final CombatParticipantsService combatParticipantsService;

    @GetMapping
    public ResponseEntity<Page<CombatParticipantsResponseDTO>> findAll(
            @PageableDefault(size = 5, sort={"initiative"}, direction = Sort.Direction.DESC)Pageable pagination
            ) {
        return ResponseEntity.ok(combatParticipantsService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CombatParticipantsResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(combatParticipantsService.findById(id));
    }

    @GetMapping("/search/{type}")
    public ResponseEntity<Page<CombatParticipantsResponseDTO>> findByType(
            @PageableDefault(size = 5, sort = {"initiative"}, direction = Sort.Direction.DESC)Pageable pagination,
            @PathVariable("type") ParticipantType type
    ) {
        return ResponseEntity.ok(combatParticipantsService.findByType(type, pagination));
    }

    @GetMapping("/by-combat/{id}")
    public ResponseEntity<Page<CombatParticipantsResponseDTO>> findByIdCombat(
            @PageableDefault(size = 5, sort = {"initiative"}, direction = Sort.Direction.DESC)Pageable pagination,
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(combatParticipantsService.findByIdCombat(id, pagination));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CombatParticipantsResponseDTO> save(
            @Valid @RequestBody CombatParticipantsRequestDTO combatParticipantsRequest
    ) {
        CombatParticipantsResponseDTO saveCombatParticipant = combatParticipantsService.save(combatParticipantsRequest);

        return ResponseEntity.ok(saveCombatParticipant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CombatParticipantsResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody CombatParticipantsRequestDTO combatParticipantsRequest
    ) {
        CombatParticipantsResponseDTO combatParticipantUpdate = combatParticipantsService.update(id, combatParticipantsRequest);

        return ResponseEntity.ok(combatParticipantUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        combatParticipantsService.deleteId(id);

        return ResponseEntity.noContent().build();
    }
}
