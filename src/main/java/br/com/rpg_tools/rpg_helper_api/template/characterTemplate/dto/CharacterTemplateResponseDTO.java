package br.com.rpg_tools.rpg_helper_api.template.characterTemplate.dto;

import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.model.CharacterTemplate;

public record CharacterTemplateResponseDTO(
        Long id,
        String name,
        Number healthPoints,
        String armor,
        String race,
        String classes,
        String passivePerception,
        String notes,
        Long userId
) {
    public CharacterTemplateResponseDTO(CharacterTemplate characterTemplate) {
        this(
                characterTemplate.getId(),
                characterTemplate.getName(),
                characterTemplate.getHealth_points(),
                characterTemplate.getArmor(),
                characterTemplate.getRace(),
                characterTemplate.getClasses(),
                characterTemplate.getPassive_perception(),
                characterTemplate.getNotes(),
                characterTemplate.getUser() != null ? characterTemplate.getUser().getId() : null
        );
    }
}