package br.com.rpg_tools.rpg_helper_api.campaigns.campaign.model;

import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.dto.CampaignRequestDTO;
import br.com.rpg_tools.rpg_helper_api.model.User;
import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.dto.CharacterTemplateRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "campaign")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String system;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public static Campaign fromDto(CampaignRequestDTO dto) {
        Campaign campaign = new Campaign();
        campaign.setName(dto.name());
        campaign.setSystem(dto.system());
        return campaign;
    }

    public void updateFromDto(CampaignRequestDTO dto){
        this.setName(dto.name());
        this.setSystem(dto.system());
        // user set in service
    }
}
