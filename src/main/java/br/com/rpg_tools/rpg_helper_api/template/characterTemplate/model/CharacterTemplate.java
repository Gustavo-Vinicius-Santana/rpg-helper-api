package br.com.rpg_tools.rpg_helper_api.template.characterTemplate.model;

import br.com.rpg_tools.rpg_helper_api.model.User;
import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.dto.CharacterTemplateRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "character_template")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Number health_points;

    private String armor;

    private String race;

    private String classes;

    private String passive_perception;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public static CharacterTemplate fromDto(CharacterTemplateRequestDTO dto) {
        CharacterTemplate characterTemplate = new CharacterTemplate();
        characterTemplate.setName(dto.name());
        characterTemplate.setHealth_points(dto.healthPoints());
        characterTemplate.setArmor(dto.armor());
        characterTemplate.setRace(dto.race());
        characterTemplate.setClasses(dto.classes());
        characterTemplate.setPassive_perception(dto.passivePerception());
        characterTemplate.setNotes(dto.notes());
        return characterTemplate;
    }

    public void updateFromDto(CharacterTemplateRequestDTO dto){
        this.setName(dto.name());
        this.setHealth_points(dto.healthPoints());
        this.setArmor(dto.armor());
        this.setRace(dto.race());
        this.setClasses(dto.classes());
        this.setPassive_perception(dto.passivePerception());
        this.setNotes(dto.notes());
        // user set in service
    }
}
