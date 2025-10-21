package br.com.rpg_tools.rpg_helper_api.controller;

import br.com.rpg_tools.rpg_helper_api.dto.CharacterCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CharacterCombatResponseDTO;
import br.com.rpg_tools.rpg_helper_api.service.CharacterCombatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character-combats")
@RequiredArgsConstructor
public class CharacterCombatController {

    private final CharacterCombatService characterCombatService;

    @GetMapping
    public ResponseEntity<CharacterCombatResponseDTO> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterCombatResponseDTO> findById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<CharacterCombatResponseDTO> findByName(@PathVariable("name") String name) {
        return null;
    }

    @PostMapping
    public ResponseEntity<CharacterCombatResponseDTO> save(
            @Valid @RequestBody CharacterCombatRequestDTO characterCombatRequest
    ) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterCombatResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody CharacterCombatRequestDTO characterCombatRequest
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {

    }
}
