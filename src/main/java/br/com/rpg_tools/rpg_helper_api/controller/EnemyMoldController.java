package br.com.rpg_tools.rpg_helper_api.controller;

import br.com.rpg_tools.rpg_helper_api.dto.EnemyMoldRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.EnemyMoldResponseDTO;
import br.com.rpg_tools.rpg_helper_api.service.EnemyMoldService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enemy-molds")
@RequiredArgsConstructor
public class EnemyMoldController {

    private final EnemyMoldService enemyMoldService;

    @GetMapping
    public ResponseEntity<EnemyMoldResponseDTO> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnemyMoldResponseDTO> findById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<EnemyMoldResponseDTO> findByName(@PathVariable("name") String name) {
        return null;
    }

    @PostMapping
    public ResponseEntity<EnemyMoldResponseDTO> save(
            @Valid @RequestBody EnemyMoldRequestDTO enemyMoldRequest
    ) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnemyMoldResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody EnemyMoldRequestDTO enemyMoldRequest
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {

    }
}
