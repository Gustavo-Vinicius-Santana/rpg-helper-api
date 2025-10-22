package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CampaignCharactersRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CampaignCharactersResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignCharactersServiceIml implements CampaignCharactersService {
    @Override
    public List<CampaignCharactersResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public CampaignCharactersResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public CampaignCharactersResponseDTO findByName(String name) {
        return null;
    }

    @Override
    public CampaignCharactersResponseDTO save(CampaignCharactersRequestDTO campaignCharacter) {
        return null;
    }

    @Override
    public CampaignCharactersResponseDTO update(CampaignCharactersRequestDTO campaignCharacter) {
        return null;
    }

    @Override
    public void deleteId(long id) {

    }
}
