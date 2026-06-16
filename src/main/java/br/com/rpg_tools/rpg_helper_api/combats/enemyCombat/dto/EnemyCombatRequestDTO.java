package br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.dto;

public record EnemyCombatRequestDTO(
        String name,
        Number total_health_points,
        Number current_health_points,
        String armor,
        String damage,
        String notes,
        Long combatParticipantId
) {
}
