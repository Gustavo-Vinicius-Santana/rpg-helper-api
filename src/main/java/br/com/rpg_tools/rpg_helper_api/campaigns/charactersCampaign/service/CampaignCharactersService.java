package br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.service;

import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.dto.CampaignCharactersRequestDTO;
import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.dto.CampaignCharactersResponseDTO;

import java.util.List;

public interface CampaignCharactersService {
    List<CampaignCharactersResponseDTO> findAll();

    CampaignCharactersResponseDTO findById(Long id);

    CampaignCharactersResponseDTO findByName(String name);

    CampaignCharactersResponseDTO save(CampaignCharactersRequestDTO campaignCharacter);

    CampaignCharactersResponseDTO update(CampaignCharactersRequestDTO campaignCharacter);

    void deleteId(long id);
}
