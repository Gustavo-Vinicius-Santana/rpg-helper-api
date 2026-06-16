package br.com.rpg_tools.rpg_helper_api.combats.combat.dto;

public record CombatRequestDTO(
        String name,
        Long turn,
        Long round,
        Long time,
        Long gap,
        Long userId
) {
}
