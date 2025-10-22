package br.com.rpg_tools.rpg_helper_api.repository;

import br.com.rpg_tools.rpg_helper_api.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
