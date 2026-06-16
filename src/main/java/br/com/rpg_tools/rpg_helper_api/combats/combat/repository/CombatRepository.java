package br.com.rpg_tools.rpg_helper_api.combats.combat.repository;

import br.com.rpg_tools.rpg_helper_api.combats.combat.model.Combat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombatRepository extends JpaRepository<Combat, Long> {
    Page<Combat> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
