package br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.model;

import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.model.Campaign;
import br.com.rpg_tools.rpg_helper_api.campaigns.charactersCampaign.dto.CampaignCharactersRequestDTO;
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

    public static CampaignCharacters fromDto(CampaignCharactersRequestDTO dto) {
        CampaignCharacters campaignCharacters = new CampaignCharacters();
        campaignCharacters.setName(dto.name());
        campaignCharacters.setPlayer(dto.player());
        campaignCharacters.setHealth_points(dto.healthPoints());
        campaignCharacters.setArmor(dto.armor());
        campaignCharacters.setRace(dto.race());
        campaignCharacters.setClasses(dto.classes());
        campaignCharacters.setPassive_perception(dto.passivePerception());
        campaignCharacters.setNotes(dto.notes());
        return campaignCharacters;
    }

    public void updateFromDto(CampaignCharactersRequestDTO dto){
        this.setName(dto.name());
        this.setPlayer(dto.player());
        this.setHealth_points(dto.healthPoints());
        this.setArmor(dto.armor());
        this.setRace(dto.race());
        this.setClasses(dto.classes());
        this.setPassive_perception(dto.passivePerception());
        this.setNotes(dto.notes());
        // campaign set in service
    }
}
