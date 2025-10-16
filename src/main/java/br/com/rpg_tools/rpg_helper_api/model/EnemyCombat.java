package br.com.rpg_tools.rpg_helper_api.model;

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

    private Number health_points;

    private String armor;

    private String damage;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "combat_participants_id")
    private CombatParticipants combatParticipants;
}
