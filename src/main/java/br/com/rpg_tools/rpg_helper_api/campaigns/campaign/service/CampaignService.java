package br.com.rpg_tools.rpg_helper_api.campaigns.campaign.service;

import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.dto.CampaignRequestDTO;
import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.dto.CampaignResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CampaignService {
    Page<CampaignResponseDTO> findAll(Pageable pagination);

    CampaignResponseDTO findById(Long id);

    Page<CampaignResponseDTO> findByName(String name, Pageable pagination);

    CampaignResponseDTO save(CampaignRequestDTO campaign);

    CampaignResponseDTO update(Long id, CampaignRequestDTO campaign);

    void deleteId(long id);
}
