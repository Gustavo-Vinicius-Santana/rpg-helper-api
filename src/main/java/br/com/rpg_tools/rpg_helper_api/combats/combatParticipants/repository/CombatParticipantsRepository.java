package br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.repository;

import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.CombatParticipant;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.ParticipantType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombatParticipantsRepository extends JpaRepository<CombatParticipant,Long> {
    @EntityGraph(attributePaths = {"characterCombat", "enemyCombat", "combat"})
    Page<CombatParticipant> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"characterCombat", "enemyCombat", "combat"})
    Page<CombatParticipant> findByType(ParticipantType type, Pageable pageable);

    @EntityGraph(attributePaths = {"characterCombat", "enemyCombat", "combat"})
    CombatParticipant findWithRelationsById(Long id);

    Page<CombatParticipant> findByCombatId(Long combatId, Pageable pageable);
}
