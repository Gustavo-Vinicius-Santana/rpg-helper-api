package br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.service;

import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.model.CharacterTemplate;
import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.dto.EnemyTemplateRequestDTO;
import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.dto.EnemyTemplateResponseDTO;
import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.model.EnemyTemplate;
import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.repository.EnemyTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnemyTemplateServiceImpl implements EnemyTemplateService {

    private final EnemyTemplateRepository enemyTemplateRepository;

    @Override
    public Page<EnemyTemplateResponseDTO> findAll(Pageable pagination) {
        return enemyTemplateRepository.findAll(pagination)
                .map(EnemyTemplateResponseDTO::new);
    }

    @Override
    public EnemyTemplateResponseDTO findById(Long id) {
        return enemyTemplateRepository.findById(id)
                .map(EnemyTemplateResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Enemy template not found with id:" + id));
    }

    @Override
    public Page<EnemyTemplateResponseDTO> findByName(String name, Pageable pagination) {
        return enemyTemplateRepository.findByNameContaining(name, pagination)
                .map(EnemyTemplateResponseDTO::new);
    }

    @Override
    public EnemyTemplateResponseDTO save(EnemyTemplateRequestDTO enemyTemplate) {
        var enemy = EnemyTemplate.fromDto(enemyTemplate);

        var saveEnemy = enemyTemplateRepository.save(enemy);

        return new EnemyTemplateResponseDTO(saveEnemy);
    }

    @Override
    public EnemyTemplateResponseDTO update(long id, EnemyTemplateRequestDTO enemyTemplateRequest) {
        var existingEnemy = enemyTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enemy template not found with id:" + id));

        existingEnemy.updateFromDto(enemyTemplateRequest);

        var updateEnemy = enemyTemplateRepository.save(existingEnemy);

        return new EnemyTemplateResponseDTO(updateEnemy);
    }

    @Override
    public void deleteId(long id) {
        enemyTemplateRepository.deleteById(id);
    }
}
