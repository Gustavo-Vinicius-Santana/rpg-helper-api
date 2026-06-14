package br.com.rpg_tools.rpg_helper_api.campaigns.campaign.service;

import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.dto.CampaignRequestDTO;
import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.dto.CampaignResponseDTO;
import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.model.Campaign;
import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CampaignServiceIml implements CampaignService {

    private final CampaignRepository campaignRepository;

    @Override
    public Page<CampaignResponseDTO> findAll(Pageable pagination) {
        return campaignRepository.findAll(pagination)
                .map(CampaignResponseDTO::new);
    }

    @Override
    public CampaignResponseDTO findById(Long id) {
        return campaignRepository.findById(id)
                .map(CampaignResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("campaing not found with id" + id));
    }

    @Override
    public Page<CampaignResponseDTO> findByName(String name, Pageable pagination) {
        return campaignRepository.findByNameContaining(name, pagination)
                .map(CampaignResponseDTO::new);
    }

    @Override
    public CampaignResponseDTO save(CampaignRequestDTO campaign) {
        var newCampaign = Campaign.fromDto(campaign);

        var saveCampaign = campaignRepository.save(newCampaign);

        return new CampaignResponseDTO(saveCampaign);
    }

    @Override
    public CampaignResponseDTO update(Long id, CampaignRequestDTO campaign) {
        var existingCampaign = campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        existingCampaign.updateFromDto(campaign);

        var updatedCampaign = campaignRepository.save(existingCampaign);

        return new CampaignResponseDTO(updatedCampaign);
    }

    @Override
    public void deleteId(long id) {
        campaignRepository.deleteById(id);
    }
}
