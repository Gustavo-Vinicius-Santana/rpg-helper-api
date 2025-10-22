package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CampaignRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CampaignResponseDTO;

import java.util.List;

public interface CampaignService {
    List<CampaignResponseDTO> findAll();

    CampaignResponseDTO findById(Long id);

    CampaignResponseDTO findByName(String name);

    CampaignResponseDTO save(CampaignRequestDTO campaign);

    CampaignResponseDTO update(CampaignRequestDTO campaign);

    void deleteId(long id);
}
