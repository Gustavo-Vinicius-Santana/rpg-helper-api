package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CampaignRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CampaignResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignServiceIml implements CampaignService {
    @Override
    public List<CampaignResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public CampaignResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public CampaignResponseDTO findByName(String name) {
        return null;
    }

    @Override
    public CampaignResponseDTO save(CampaignRequestDTO campaign) {
        return null;
    }

    @Override
    public CampaignResponseDTO update(CampaignRequestDTO campaign) {
        return null;
    }

    @Override
    public void deleteId(long id) {

    }
}
