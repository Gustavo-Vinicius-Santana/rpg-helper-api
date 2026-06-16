package br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.model;

import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.CombatParticipant;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.dto.EnemyCombatRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "enemy_combat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnemyCombat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Number total_health_points;

    private Number current_health_points;

    private String armor;

    private String damage;

    private String notes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "combat_participants_id",
            nullable = false,
            unique = true
    )
    private CombatParticipant combatParticipant;

    public static EnemyCombat fromDto(EnemyCombatRequestDTO dto){
        EnemyCombat enemyCombat = new EnemyCombat();
        enemyCombat.setName(dto.name());
        enemyCombat.setTotal_health_points(dto.total_health_points());
        enemyCombat.setCurrent_health_points(dto.current_health_points());
        enemyCombat.setArmor(dto.armor());
        enemyCombat.setDamage(dto.damage());
        enemyCombat.setNotes(dto.notes());
        return enemyCombat;
    }

    public void updateFromDto(EnemyCombatRequestDTO dto) {
        this.setName(dto.name());
        this.setTotal_health_points(dto.total_health_points());
        this.setCurrent_health_points(dto.current_health_points());
        this.setArmor(dto.armor());
        this.setDamage(dto.damage());
        this.setNotes(dto.notes());
        // combatParticipant set in service
    }
}
