package br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.dto;

import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.model.CampaignCharacters;

public record CampaignCharactersResponseDTO(
        Long id,
        String name,
        String player,
        Number healthPoints,
        String armor,
        String race,
        String classes,
        String passivePerception,
        String notes
) {
    public CampaignCharactersResponseDTO(CampaignCharacters campaignCharacters) {
        this(
                campaignCharacters.getId(),
                campaignCharacters.getName(),
                campaignCharacters.getPlayer(),
                campaignCharacters.getHealth_points(),
                campaignCharacters.getArmor(),
                campaignCharacters.getRace(),
                campaignCharacters.getClasses(),
                campaignCharacters.getPassive_perception(),
                campaignCharacters.getNotes()
        );
    }
}
