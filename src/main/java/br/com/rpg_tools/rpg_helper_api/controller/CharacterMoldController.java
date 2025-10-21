package br.com.rpg_tools.rpg_helper_api.controller;

import br.com.rpg_tools.rpg_helper_api.dto.CharacterMoldRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CharacterMoldResponseDTO;
import br.com.rpg_tools.rpg_helper_api.service.CharacterMoldService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character-molds")
@RequiredArgsConstructor
public class CharacterMoldController {

    private final CharacterMoldService characterMoldService;

    @GetMapping
    public ResponseEntity<CharacterMoldResponseDTO> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterMoldResponseDTO> findById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<CharacterMoldResponseDTO> findByName(@PathVariable("name") String name) {
        return null;
    }

    @PostMapping
    public ResponseEntity<CharacterMoldResponseDTO> save(
            @Valid @RequestBody CharacterMoldRequestDTO characterMoldRequest
    ) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterMoldResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody CharacterMoldRequestDTO characterMoldRequest
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {

    }
}
