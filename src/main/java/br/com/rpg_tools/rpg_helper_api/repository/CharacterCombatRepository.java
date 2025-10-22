package br.com.rpg_tools.rpg_helper_api.repository;

import br.com.rpg_tools.rpg_helper_api.model.CharacterCombat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterCombatRepository extends JpaRepository<CharacterCombat, Long> {
}
