package br.com.rpg_tools.rpg_helper_api.repository;

import br.com.rpg_tools.rpg_helper_api.model.CampaignCharacters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignCharactersRepository extends JpaRepository<CampaignCharacters, Long> {
}
