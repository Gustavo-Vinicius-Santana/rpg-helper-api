package br.com.rpg_tools.rpg_helper_api.repository;

import br.com.rpg_tools.rpg_helper_api.model.EnemyCombat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnemyCombatRepository extends JpaRepository<EnemyCombat, Long> {
}
