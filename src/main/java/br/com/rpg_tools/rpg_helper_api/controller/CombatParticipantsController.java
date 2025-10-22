package br.com.rpg_tools.rpg_helper_api.controller;

import br.com.rpg_tools.rpg_helper_api.dto.CombatParticipantsRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CombatParticipantsResponseDTO;
import br.com.rpg_tools.rpg_helper_api.service.CombatParticipantsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/combat-participants")
@RequiredArgsConstructor
public class CombatParticipantsController {

    private final CombatParticipantsService combatParticipantsService;

    @GetMapping
    public ResponseEntity<CombatParticipantsResponseDTO> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CombatParticipantsResponseDTO> findById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<CombatParticipantsResponseDTO> findByName(@PathVariable("name") String name) {
        return null;
    }

    @PostMapping
    public ResponseEntity<CombatParticipantsResponseDTO> save(
            @Valid @RequestBody CombatParticipantsRequestDTO combatParticipantsRequest
    ) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CombatParticipantsResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody CombatParticipantsRequestDTO combatParticipantsRequest
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {

    }
}
