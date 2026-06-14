package br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.dto;

public record CampaignCharactersRequestDTO(
        String name,
        String player,
        Number healthPoints,
        String armor,
        String race,
        String classes,
        String passivePerception,
        String notes,
        Long campaignId
) {
}
