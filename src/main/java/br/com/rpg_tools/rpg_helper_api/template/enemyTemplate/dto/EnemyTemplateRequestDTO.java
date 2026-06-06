package br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.dto;

public record EnemyTemplateRequestDTO(
        Long id,
        String name,
        Number health_points,
        String armor,
        String damage,
        String notes,
        Long userId
) {
}
