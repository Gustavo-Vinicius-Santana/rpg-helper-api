package br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.service;

import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.dto.CampaignCharactersRequestDTO;
import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.dto.CampaignCharactersResponseDTO;
import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.model.CampaignCharacters;
import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.repository.CampaignCharactersRepository;
import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CampaignCharactersServiceIml implements CampaignCharactersService {

    private final CampaignCharactersRepository campaignCharactersRepository;
    private final CampaignRepository campaignRepository;

    @Override
    public Page<CampaignCharactersResponseDTO> findAll(Pageable pagination) {
        return campaignCharactersRepository.findAll(pagination)
                .map(CampaignCharactersResponseDTO::new);
    }

    @Override
    public CampaignCharactersResponseDTO findById(Long id) {
        return campaignCharactersRepository.findById(id)
                .map(CampaignCharactersResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Campaign character not found with id: " + id));
    }

    @Override
    public Page<CampaignCharactersResponseDTO> findByName(String name, Pageable pagination) {
        return campaignCharactersRepository
                .findByNameContaining(name, pagination)
                .map(CampaignCharactersResponseDTO::new);
    }

    @Override
    public CampaignCharactersResponseDTO save(CampaignCharactersRequestDTO campaignCharacter) {
        var character = CampaignCharacters.fromDto(campaignCharacter);

        var campaign = campaignRepository.findById(campaignCharacter.campaignId())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
        character.setCampaign(campaign);

        var saveCharacter = campaignCharactersRepository.save(character);

        return new CampaignCharactersResponseDTO(saveCharacter);
    }

    @Override
    public CampaignCharactersResponseDTO update(Long id, CampaignCharactersRequestDTO campaignCharacter) {
        var existingCharacter = campaignCharactersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign character not found"));

        existingCharacter.updateFromDto(campaignCharacter);

        var updatedCharacter = campaignCharactersRepository.save(existingCharacter);

        return new CampaignCharactersResponseDTO(updatedCharacter);
    }

    @Override
    public void deleteId(long id) {
        campaignCharactersRepository.deleteById(id);
    }
}
