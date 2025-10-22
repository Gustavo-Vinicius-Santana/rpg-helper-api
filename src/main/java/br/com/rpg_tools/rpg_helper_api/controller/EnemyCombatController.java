package br.com.rpg_tools.rpg_helper_api.controller;

import br.com.rpg_tools.rpg_helper_api.dto.EnemyCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.EnemyCombatResponseDTO;
import br.com.rpg_tools.rpg_helper_api.service.EnemyCombatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enemy-combats")
@RequiredArgsConstructor
public class EnemyCombatController {

    private final EnemyCombatService enemyCombatService;

    @GetMapping
    public ResponseEntity<EnemyCombatResponseDTO> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnemyCombatResponseDTO> findById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<EnemyCombatResponseDTO> findByName(@PathVariable("name") String name) {
        return null;
    }

    @PostMapping
    public ResponseEntity<EnemyCombatResponseDTO> save(
            @Valid @RequestBody EnemyCombatRequestDTO enemyCombatRequest
    ) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnemyCombatResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody EnemyCombatRequestDTO enemyCombatRequest
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {

    }
}
