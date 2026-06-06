package br.com.rpg_tools.rpg_helper_api.campaigns.campaign.repository;

import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.model.Campaign;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    Page<Campaign> findByNameContaining(String name, Pageable pageable);
}
