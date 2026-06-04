package br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.controller;

import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.dto.EnemyTemplateRequestDTO;
import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.dto.EnemyTemplateResponseDTO;
import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.service.EnemyTemplateService;
import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.service.EnemyTemplateServiceImpl;
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
@RequestMapping("/enemy-templates")
@RequiredArgsConstructor
public class EnemyTemplateController {

    private final EnemyTemplateServiceImpl enemyTemplateService;

    @GetMapping
    public ResponseEntity<Page<EnemyTemplateResponseDTO>> findAll(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pagination
            ) {
        return ResponseEntity.ok(enemyTemplateService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnemyTemplateResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(enemyTemplateService.findById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Page<EnemyTemplateResponseDTO>> findByName(
            @PageableDefault(size = 5, sort= {"name"}, direction = Sort.Direction.ASC)Pageable pagination,
            @PathVariable("name") String name
    ) {
        return ResponseEntity.ok(enemyTemplateService.findByName(name, pagination));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnemyTemplateResponseDTO> save(
            @Valid @RequestBody EnemyTemplateRequestDTO enemyTemplateRequest
    ) {
        EnemyTemplateResponseDTO saveEnemy = enemyTemplateService.save(enemyTemplateRequest);

        return ResponseEntity.ok(saveEnemy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnemyTemplateResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody EnemyTemplateRequestDTO enemyTemplateRequest
    ) {
        EnemyTemplateResponseDTO enemyUpdate = enemyTemplateService.update(id, enemyTemplateRequest);

        return ResponseEntity.ok(enemyUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        enemyTemplateService.deleteId(id);

        return ResponseEntity.noContent().build();
    }
}
