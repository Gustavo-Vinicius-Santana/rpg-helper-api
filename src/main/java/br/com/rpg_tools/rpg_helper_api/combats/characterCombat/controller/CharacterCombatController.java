package br.com.rpg_tools.rpg_helper_api.combats.characterCombat.controller;

import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.dto.CharacterCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.dto.CharacterCombatResponseDTO;
import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.service.CharacterCombatService;
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
@RequestMapping("/character-combats")
@RequiredArgsConstructor
public class CharacterCombatController {

    private final CharacterCombatService characterCombatService;

    @GetMapping
    public ResponseEntity<Page<CharacterCombatResponseDTO>> findAll(
            @PageableDefault(size = 5, sort={"name"}, direction = Sort.Direction.ASC)Pageable pagination
            ) {
        return ResponseEntity.ok(characterCombatService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterCombatResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(characterCombatService.findById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Page<CharacterCombatResponseDTO>> findByName(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pagination,
            @PathVariable("name") String name
    ) {
        return ResponseEntity.ok(characterCombatService.findByName(name, pagination));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterCombatResponseDTO> save(
            @Valid @RequestBody CharacterCombatRequestDTO characterCombatRequest
    ) {
        CharacterCombatResponseDTO saveCharacterCombat = characterCombatService.save(characterCombatRequest);

        return ResponseEntity.ok(saveCharacterCombat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterCombatResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody CharacterCombatRequestDTO characterCombatRequest
    ) {
        CharacterCombatResponseDTO characterCombatUpdate = characterCombatService.update(id, characterCombatRequest);

        return ResponseEntity.ok(characterCombatUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        characterCombatService.deleteId(id);

        return ResponseEntity.noContent().build();
    }
}
