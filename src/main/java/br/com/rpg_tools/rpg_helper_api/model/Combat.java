package br.com.rpg_tools.rpg_helper_api.model;

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
}
