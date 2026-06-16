package br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.service;

import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.CombatParticipant;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.repository.CombatParticipantsRepository;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.dto.EnemyCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.dto.EnemyCombatResponseDTO;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.model.EnemyCombat;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.repository.EnemyCombatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnemyCombatServiceIml implements EnemyCombatService {

    private final EnemyCombatRepository enemyCombatRepository;
    private final CombatParticipantsRepository combatParticipantsRepository;

    @Override
    public Page<EnemyCombatResponseDTO> findAll(Pageable pagination) {
        return enemyCombatRepository.findAll(pagination)
                .map(EnemyCombatResponseDTO::new);
    }

    @Override
    public EnemyCombatResponseDTO findById(Long id) {
        return enemyCombatRepository.findById(id)
                .map(EnemyCombatResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("enemy combat not found with id: " + id));
    }

    @Override
    public Page<EnemyCombatResponseDTO> findByName(String name, Pageable pageable) {
        return enemyCombatRepository.findByNameContainingIgnoreCase(name, pageable)
                .map(EnemyCombatResponseDTO::new);
    }

    @Override
    public EnemyCombatResponseDTO save(EnemyCombatRequestDTO combat) {
        var newEnemyCombat = EnemyCombat.fromDto(combat);

        if (combat.combatParticipantId() != null) {
            CombatParticipant combatParticipant = combatParticipantsRepository.findById(combat.combatParticipantId())
                    .orElseThrow(() -> new RuntimeException("combat participant not found with id: " + combat.combatParticipantId()));
            newEnemyCombat.setCombatParticipant(combatParticipant);
        }

        var saveEnemyCombat = enemyCombatRepository.save(newEnemyCombat);

        return new EnemyCombatResponseDTO(saveEnemyCombat);
    }

    @Override
    public EnemyCombatResponseDTO update(long id, EnemyCombatRequestDTO combat) {
        var existingEnemyCombat = enemyCombatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("enemy combat not found"));

        existingEnemyCombat.updateFromDto(combat);

        if (combat.combatParticipantId() != null) {
            CombatParticipant combatParticipant = combatParticipantsRepository.findById(combat.combatParticipantId())
                    .orElseThrow(() -> new RuntimeException("combat participant not found with id: " + combat.combatParticipantId()));
            existingEnemyCombat.setCombatParticipant(combatParticipant);
        }

        var updateEnemyCombat = enemyCombatRepository.save(existingEnemyCombat);

        return new EnemyCombatResponseDTO(updateEnemyCombat);
    }

    @Override
    public void deleteId(long id) {
        enemyCombatRepository.deleteById(id);
    }
}
