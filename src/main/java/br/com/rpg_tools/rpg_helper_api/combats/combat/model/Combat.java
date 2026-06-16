package br.com.rpg_tools.rpg_helper_api.combats.combat.model;

import br.com.rpg_tools.rpg_helper_api.combats.combat.dto.CombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "combat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Combat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long turn;

    @Column(nullable = false)
    private Long round;

    @Column(nullable = false)
    private Long time;

    @Column(nullable = false)
    private Long gap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public static Combat fromDto(CombatRequestDTO dto){
        Combat combat = new Combat();
        combat.setName(dto.name());
        combat.setTurn(dto.turn());
        combat.setRound(dto.round());
        combat.setTime(dto.time());
        combat.setGap(dto.gap());
        return combat;
    }

    public void updateFromDto(CombatRequestDTO dto) {
        this.setName(dto.name());
        this.setTurn(dto.turn());
        this.setRound(dto.round());
        this.setTime(dto.time());
        this.setGap(dto.gap());
        // user set in service
    }
}
