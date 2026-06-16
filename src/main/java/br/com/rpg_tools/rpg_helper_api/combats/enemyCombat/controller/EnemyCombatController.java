package br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.controller;

import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.dto.EnemyCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.dto.EnemyCombatResponseDTO;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.service.EnemyCombatService;
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
@RequestMapping("/enemy-combats")
@RequiredArgsConstructor
public class EnemyCombatController {

    private final EnemyCombatService enemyCombatService;

    @GetMapping
    public ResponseEntity<Page<EnemyCombatResponseDTO>> findAll(
            @PageableDefault(size = 5, sort={"name"}, direction = Sort.Direction.ASC)Pageable pagination
            ) {
        return ResponseEntity.ok(enemyCombatService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnemyCombatResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(enemyCombatService.findById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Page<EnemyCombatResponseDTO>> findByName(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pagination,
            @PathVariable("name") String name
    ) {
        return ResponseEntity.ok(enemyCombatService.findByName(name, pagination));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnemyCombatResponseDTO> save(
            @Valid @RequestBody EnemyCombatRequestDTO enemyCombatRequest
    ) {
        EnemyCombatResponseDTO saveEnemyCombat = enemyCombatService.save(enemyCombatRequest);

        return ResponseEntity.ok(saveEnemyCombat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnemyCombatResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody EnemyCombatRequestDTO enemyCombatRequest
    ) {
        EnemyCombatResponseDTO enemyCombatUpdate = enemyCombatService.update(id, enemyCombatRequest);

        return ResponseEntity.ok(enemyCombatUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        enemyCombatService.deleteId(id);

        return ResponseEntity.noContent().build();
    }
}
