package br.com.rpg_tools.rpg_helper_api.combats.combat.dto;

import br.com.rpg_tools.rpg_helper_api.combats.combat.model.Combat;

public record CombatResponseDTO(
        Long id,
        String name,
        Long turn,
        Long round,
        Long time,
        Long gap,
        Long userId
) {
    public CombatResponseDTO(Combat combat){
        this(
                combat.getId(),
                combat.getName(),
                combat.getTurn(),
                combat.getRound(),
                combat.getTime(),
                combat.getGap(),
                combat.getUser() != null ? combat.getUser().getId() : null
        );
    }
}
