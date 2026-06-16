package br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.dto;

import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.model.EnemyCombat;

public record EnemyCombatResponseDTO(
        Long id,
        String name,
        Number total_health_points,
        Number current_health_points,
        String armor,
        String damage,
        String notes,
        Long combatParticipantId
) {
    public EnemyCombatResponseDTO(EnemyCombat enemyCombat){
        this(
                enemyCombat.getId(),
                enemyCombat.getName(),
                enemyCombat.getTotal_health_points(),
                enemyCombat.getCurrent_health_points(),
                enemyCombat.getArmor(),
                enemyCombat.getDamage(),
                enemyCombat.getNotes(),
                enemyCombat.getCombatParticipant() != null ? enemyCombat.getCombatParticipant().getId() : null
        );
    }
}
