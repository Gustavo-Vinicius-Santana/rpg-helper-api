package br.com.rpg_tools.rpg_helper_api.repository;

import br.com.rpg_tools.rpg_helper_api.model.CombatParticipants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombatParticipantsRepository extends JpaRepository<CombatParticipants,Long> {
}
