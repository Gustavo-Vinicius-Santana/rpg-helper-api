package br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.service;

import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.dto.CampaignCharactersRequestDTO;
import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.dto.CampaignCharactersResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CampaignCharactersService {
    Page<CampaignCharactersResponseDTO> findAll(Pageable pagination);

    CampaignCharactersResponseDTO findById(Long id);

    Page<CampaignCharactersResponseDTO> findByName(String name, Pageable pagination);

    CampaignCharactersResponseDTO save(CampaignCharactersRequestDTO campaignCharacter);

    CampaignCharactersResponseDTO update(Long id, CampaignCharactersRequestDTO campaignCharacter);

    void deleteId(long id);
}
