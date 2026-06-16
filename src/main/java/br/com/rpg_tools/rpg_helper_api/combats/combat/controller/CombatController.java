package br.com.rpg_tools.rpg_helper_api.combats.combat.controller;

import br.com.rpg_tools.rpg_helper_api.combats.combat.dto.CombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combat.dto.CombatResponseDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combat.service.CombatService;
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
@RequestMapping("/combats")
@RequiredArgsConstructor
public class CombatController {

    private final CombatService combatService;

    @GetMapping
    public ResponseEntity<Page<CombatResponseDTO>> findAll(
            @PageableDefault(size = 5, sort={"name"}, direction = Sort.Direction.ASC)Pageable pagination
            ) {
        return ResponseEntity.ok(combatService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CombatResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(combatService.findById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Page<CombatResponseDTO>> findByName(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pagination,
            @PathVariable("name") String name
    ) {
        return ResponseEntity.ok(combatService.findByName(name, pagination));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CombatResponseDTO> save(
            @Valid @RequestBody CombatRequestDTO combatRequest
    ) {
        CombatResponseDTO saveCombat = combatService.save(combatRequest);

        return ResponseEntity.ok(saveCombat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CombatResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody CombatRequestDTO combatRequest
    ) {
        CombatResponseDTO combatUpdate = combatService.update(id, combatRequest);

        return ResponseEntity.ok(combatUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        combatService.deleteId(id);

        return ResponseEntity.noContent().build();
    }
}
