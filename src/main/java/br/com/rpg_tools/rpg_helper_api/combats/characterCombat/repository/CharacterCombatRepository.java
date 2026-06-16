package br.com.rpg_tools.rpg_helper_api.combats.characterCombat.repository;

import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.model.CharacterCombat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterCombatRepository extends JpaRepository<CharacterCombat, Long> {
    Page<CharacterCombat> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
