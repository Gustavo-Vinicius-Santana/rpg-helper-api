package br.com.rpg_tools.rpg_helper_api.combats.characterCombat.model;

import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.dto.CharacterCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.CombatParticipant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "character_combat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterCombat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Number total_health_points;

    private Number current_health_points;

    private String armor;

    private String race;

    private String classes;

    private  String passive_perception;

    private String notes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "combat_participants_id",
            nullable = false,
            unique = true
    )
    private CombatParticipant combatParticipant;

    public static CharacterCombat fromDto(CharacterCombatRequestDTO dto){
        CharacterCombat characterCombat = new CharacterCombat();
        characterCombat.setName(dto.name());
        characterCombat.setTotal_health_points(dto.total_health_points());
        characterCombat.setCurrent_health_points(dto.current_health_points());
        characterCombat.setArmor(dto.armor());
        characterCombat.setRace(dto.race());
        characterCombat.setClasses(dto.classes());
        characterCombat.setPassive_perception(dto.passive_perception());
        characterCombat.setNotes(dto.notes());
        return characterCombat;
    }

    public void updateFromDto(CharacterCombatRequestDTO dto) {
        this.setName(dto.name());
        this.setTotal_health_points(dto.total_health_points());
        this.setCurrent_health_points(dto.current_health_points());
        this.setArmor(dto.armor());
        this.setRace(dto.race());
        this.setClasses(dto.classes());
        this.setPassive_perception(dto.passive_perception());
        this.setNotes(dto.notes());
        // combatParticipant set in service
    }
}
