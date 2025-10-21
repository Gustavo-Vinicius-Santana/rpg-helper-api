package br.com.rpg_tools.rpg_helper_api.controller;

import br.com.rpg_tools.rpg_helper_api.dto.CombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CombatResponseDTO;
import br.com.rpg_tools.rpg_helper_api.service.CombatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/combats")
@RequiredArgsConstructor
public class CombatController {

    private final CombatService combatService;

    @GetMapping
    public ResponseEntity<CombatResponseDTO> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CombatResponseDTO> findById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<CombatResponseDTO> findByName(@PathVariable("name") String name) {
        return null;
    }

    @PostMapping
    public ResponseEntity<CombatResponseDTO> save(
            @Valid @RequestBody CombatRequestDTO combatRequest
    ) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CombatResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody CombatRequestDTO combatRequest
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {

    }
}
