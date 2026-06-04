package br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.model;

import br.com.rpg_tools.rpg_helper_api.model.User;
import br.com.rpg_tools.rpg_helper_api.template.enemyTemplate.dto.EnemyTemplateRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "enemy_template")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnemyTemplate {

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
    @JoinColumn(name = "user_id")
    private User user;

    public static EnemyTemplate fromDto(EnemyTemplateRequestDTO dto) {
        EnemyTemplate enemyTemplate = new EnemyTemplate();

        enemyTemplate.setName(dto.name());
        enemyTemplate.setHealth_points(dto.health_points());
        enemyTemplate.setArmor(dto.armor());
        enemyTemplate.setDamage(dto.damage());
        enemyTemplate.setNotes(dto.notes());

        return enemyTemplate;
    }

    public void updateFromDto(EnemyTemplateRequestDTO dto){
        this.setName(dto.name());
        this.setHealth_points(dto.health_points());
        this.setArmor(dto.armor());
        this.setDamage(dto.damage());
        this.setNotes(dto.notes());
        // user set in service
    }
}
