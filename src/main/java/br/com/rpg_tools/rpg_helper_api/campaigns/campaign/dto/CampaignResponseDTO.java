package br.com.rpg_tools.rpg_helper_api.campaigns.campaign.dto;

import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.model.Campaign;
import br.com.rpg_tools.rpg_helper_api.model.User;

public record CampaignResponseDTO(
        Long id,
        String name,
        String system,
        User user
) {
    public CampaignResponseDTO(Campaign campaign){
        this(
                campaign.getId(),
                campaign.getName(),
                campaign.getSystem(),
                campaign.getUser()
        );
    }
}
