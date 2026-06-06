package br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.repository;

import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.model.EnemyTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnemyTemplateRepository extends JpaRepository<EnemyTemplate, Long> {
    Page<EnemyTemplate> findByNameContaining(String name, Pageable pageable);
}
