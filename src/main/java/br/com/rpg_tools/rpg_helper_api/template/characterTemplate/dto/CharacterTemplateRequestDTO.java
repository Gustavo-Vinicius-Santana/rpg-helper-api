package br.com.rpg_tools.rpg_helper_api.template.characterTemplate.dto;

public record CharacterTemplateRequestDTO(
        String name,
        Number healthPoints,
        String armor,
        String race,
        String classes,
        String passivePerception,
        String notes,
        Long userId
) {
}
