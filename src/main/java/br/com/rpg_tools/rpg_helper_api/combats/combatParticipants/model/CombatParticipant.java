package br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model;

import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.model.CharacterCombat;
import br.com.rpg_tools.rpg_helper_api.combats.combat.model.Combat;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.dto.CombatParticipantsRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.model.EnemyCombat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "combat_participants")
@NamedEntityGraph(
        name = "CombatParticipant.withRelations",
        attributeNodes = {
                @NamedAttributeNode("characterCombat"),
                @NamedAttributeNode("enemyCombat"),
                @NamedAttributeNode("combat")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CombatParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Combat combat;

    @Enumerated(EnumType.STRING)
    private ParticipantType type;

    private Integer initiative;

    private Boolean defeated;

    @OneToOne(
            mappedBy = "combatParticipant",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private CharacterCombat characterCombat;

    @OneToOne(
            mappedBy = "combatParticipant",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private EnemyCombat enemyCombat;

    public static CombatParticipant fromDto(CombatParticipantsRequestDTO dto){
        CombatParticipant combatParticipant = new CombatParticipant();
        combatParticipant.setType(dto.type());
        combatParticipant.setInitiative(dto.initiative());
        combatParticipant.setDefeated(dto.defeated());
        return combatParticipant;
    }

    public void updateFromDto(CombatParticipantsRequestDTO dto) {
        this.setType(dto.type());
        this.setInitiative(dto.initiative());
        this.setDefeated(dto.defeated());
        // combat, characterCombat, enemyCombat set in service
    }
}
