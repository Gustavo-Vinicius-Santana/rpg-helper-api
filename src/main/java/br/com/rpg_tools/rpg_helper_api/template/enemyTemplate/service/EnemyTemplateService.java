package br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.service;

import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.dto.EnemyTemplateRequestDTO;
import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.dto.EnemyTemplateResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EnemyTemplateService {
    Page<EnemyTemplateResponseDTO> findAll(Pageable pagination);

    EnemyTemplateResponseDTO findById(Long id);

    Page<EnemyTemplateResponseDTO> findByName(String name, Pageable pagination);

    EnemyTemplateResponseDTO save(EnemyTemplateRequestDTO combat);

    EnemyTemplateResponseDTO update(long id, EnemyTemplateRequestDTO combat);

    void deleteId(long id);
}
