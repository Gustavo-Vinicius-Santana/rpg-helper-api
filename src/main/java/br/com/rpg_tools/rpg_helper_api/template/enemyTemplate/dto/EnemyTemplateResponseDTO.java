package br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.dto;

import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.model.EnemyTemplate;

public record EnemyTemplateResponseDTO(
        Long id,
        String name,
        Number health_points,
        String armor,
        String damage,
        String notes
) {
    public EnemyTemplateResponseDTO(EnemyTemplate enemyTemplate){
        this(
                enemyTemplate.getId(),
                enemyTemplate.getName(),
                enemyTemplate.getHealth_points(),
                enemyTemplate.getArmor(),
                enemyTemplate.getDamage(),
                enemyTemplate.getNotes()
        );
    }
}
