package br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.repository;

import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.model.EnemyCombat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnemyCombatRepository extends JpaRepository<EnemyCombat, Long> {
    Page<EnemyCombat> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
