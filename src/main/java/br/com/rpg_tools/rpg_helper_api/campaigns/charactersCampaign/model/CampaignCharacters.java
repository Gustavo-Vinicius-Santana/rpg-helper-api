package br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.model;

import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.model.Campaign;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Campaign_characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CampaignCharacters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String player;

    private Number health_points;

    private String armor;

    private String race;

    private String classes;

    private String passive_perception;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;
}
