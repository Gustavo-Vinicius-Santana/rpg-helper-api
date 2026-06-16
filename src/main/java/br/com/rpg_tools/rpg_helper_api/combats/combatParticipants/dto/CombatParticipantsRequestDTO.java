package br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.dto;

import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.ParticipantType;

public record CombatParticipantsRequestDTO(
        ParticipantType type,
        Integer initiative,
        Boolean defeated,
        Long combatId,
        Long characterCombatId,
        Long enemyCombatId
) {
}
