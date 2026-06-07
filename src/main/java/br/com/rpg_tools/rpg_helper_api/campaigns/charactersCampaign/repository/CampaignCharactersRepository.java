package br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.repository;

import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.model.CampaignCharacters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignCharactersRepository extends JpaRepository<CampaignCharacters, Long> {
    Page<CampaignCharacters> findByNameContaining(String name, Pageable pageable);
}
