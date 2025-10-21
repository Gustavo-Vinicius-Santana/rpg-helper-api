package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CampaignCharactersRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CampaignCharactersResponseDTO;

import java.util.List;

public interface CampaignCharactersService {
    List<CampaignCharactersResponseDTO> findAll();

    CampaignCharactersResponseDTO findById(Long id);

    CampaignCharactersResponseDTO findByName(String name);

    CampaignCharactersResponseDTO save(CampaignCharactersRequestDTO campaignCharacter);

    CampaignCharactersResponseDTO update(CampaignCharactersRequestDTO campaignCharacter);

    void deleteId(long id);
}
