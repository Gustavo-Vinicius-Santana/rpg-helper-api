package br.com.rpg_tools.rpg_helper_api.combats.characterCombat.dto;

public record CharacterCombatRequestDTO(
        String name,
        Number total_health_points,
        Number current_health_points,
        String armor,
        String race,
        String classes,
        String passive_perception,
        String notes,
        Long combatParticipantId
) {
}
