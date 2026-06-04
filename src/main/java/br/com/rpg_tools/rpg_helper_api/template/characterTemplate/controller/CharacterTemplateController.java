package br.com.rpg_tools.rpg_helper_api.template.characterTemplate.controller;

import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.dto.CharacterTemplateRequestDTO;
import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.dto.CharacterTemplateResponseDTO;
import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.service.CharacterTemplateServiceImpl;
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
@RequestMapping("/character-templates")
@RequiredArgsConstructor
public class CharacterTemplateController {

    private final CharacterTemplateServiceImpl characterTemplateService;

    @GetMapping
    public ResponseEntity<Page<CharacterTemplateResponseDTO>> findAll(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pagination) {
        return ResponseEntity.ok(characterTemplateService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterTemplateResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(characterTemplateService.findById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Page<CharacterTemplateResponseDTO>> findByName(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pagination,
            @PathVariable("name") String name) {
        return ResponseEntity.ok(characterTemplateService.findByName(name, pagination));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterTemplateResponseDTO> save(
            @Valid @RequestBody CharacterTemplateRequestDTO characterTemplateRequest
    ) {
        CharacterTemplateResponseDTO saveCharacter = characterTemplateService.save(characterTemplateRequest);

        return ResponseEntity.ok(saveCharacter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterTemplateResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody CharacterTemplateRequestDTO characterTemplateRequest
    ) {
        CharacterTemplateResponseDTO characterUpdate = characterTemplateService.update(id, characterTemplateRequest);

        return ResponseEntity.ok(characterUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        characterTemplateService.deleteId(id);

        return ResponseEntity.noContent().build();
    }
}
