package br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.dto;

import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.dto.CharacterCombatResponseDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.CombatParticipant;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.ParticipantType;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.dto.EnemyCombatResponseDTO;

public record CombatParticipantsResponseDTO(
        Long id,
        Long combatId,
        ParticipantType type,
        Integer initiative,
        Boolean defeated,
        CharacterCombatResponseDTO characterCombat,
        EnemyCombatResponseDTO enemyCombat
) {
    public CombatParticipantsResponseDTO(CombatParticipant combatParticipant){
        this(
                combatParticipant.getId(),
                combatParticipant.getCombat() != null ? combatParticipant.getCombat().getId() : null,
                combatParticipant.getType(),
                combatParticipant.getInitiative(),
                combatParticipant.getDefeated(),
                combatParticipant.getCharacterCombat() != null ? new CharacterCombatResponseDTO(combatParticipant.getCharacterCombat()) : null,
                combatParticipant.getEnemyCombat() != null ? new EnemyCombatResponseDTO(combatParticipant.getEnemyCombat()) : null
        );
    }
}
