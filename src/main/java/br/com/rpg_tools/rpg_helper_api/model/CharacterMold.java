package br.com.rpg_tools.rpg_helper_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "character_mold")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterMold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Number health_points;

    private String armor;

    private String race;

    private String classes;

    private  String passive_perception;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
