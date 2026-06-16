package br.com.rpg_tools.rpg_helper_api.combats.characterCombat.dto;

import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.model.CharacterCombat;

public record CharacterCombatResponseDTO(
        Long id,
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
    public CharacterCombatResponseDTO(CharacterCombat characterCombat){
        this(
                characterCombat.getId(),
                characterCombat.getName(),
                characterCombat.getTotal_health_points(),
                characterCombat.getCurrent_health_points(),
                characterCombat.getArmor(),
                characterCombat.getRace(),
                characterCombat.getClasses(),
                characterCombat.getPassive_perception(),
                characterCombat.getNotes(),
                characterCombat.getCombatParticipant() != null ? characterCombat.getCombatParticipant().getId() : null
        );
    }
}
