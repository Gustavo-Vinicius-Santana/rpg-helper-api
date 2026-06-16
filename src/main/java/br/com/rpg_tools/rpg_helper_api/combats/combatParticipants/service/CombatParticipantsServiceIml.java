package br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.service;

import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.model.CharacterCombat;
import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.repository.CharacterCombatRepository;
import br.com.rpg_tools.rpg_helper_api.combats.combat.model.Combat;
import br.com.rpg_tools.rpg_helper_api.combats.combat.repository.CombatRepository;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.dto.CombatParticipantsRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.dto.CombatParticipantsResponseDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.CombatParticipant;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.ParticipantType;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.repository.CombatParticipantsRepository;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.model.EnemyCombat;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.repository.EnemyCombatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CombatParticipantsServiceIml implements CombatParticipantsService {

    private final CombatParticipantsRepository combatParticipantsRepository;
    private final CombatRepository combatRepository;
    private final CharacterCombatRepository characterCombatRepository;
    private final EnemyCombatRepository enemyCombatRepository;

    @Override
    public Page<CombatParticipantsResponseDTO> findAll(Pageable pagination) {
        return combatParticipantsRepository.findAll(pagination)
                .map(CombatParticipantsResponseDTO::new);
    }

    @Override
    public CombatParticipantsResponseDTO findById(Long id) {
        CombatParticipant combatParticipant = combatParticipantsRepository.findWithRelationsById(id);
        if (combatParticipant == null) {
            throw new RuntimeException("combat participant not found with id: " + id);
        }
        return new CombatParticipantsResponseDTO(combatParticipant);
    }

    @Override
    public Page<CombatParticipantsResponseDTO> findByType(ParticipantType type, Pageable pageable) {
        return combatParticipantsRepository.findByType(type, pageable)
                .map(CombatParticipantsResponseDTO::new);
    }

    @Override
    public Page<CombatParticipantsResponseDTO> findByIdCombat(Long id, Pageable pageable) {
        return combatParticipantsRepository.findByCombatId(id, pageable)
                .map(CombatParticipantsResponseDTO::new);
    }

    @Override
    public CombatParticipantsResponseDTO save(CombatParticipantsRequestDTO combatParticipants) {
        var newCombatParticipant = CombatParticipant.fromDto(combatParticipants);

        if (combatParticipants.combatId() != null) {
            Combat combat = combatRepository.findById(combatParticipants.combatId())
                    .orElseThrow(() -> new RuntimeException("combat not found with id: " + combatParticipants.combatId()));
            newCombatParticipant.setCombat(combat);
        }

        if (combatParticipants.characterCombatId() != null) {
            CharacterCombat characterCombat = characterCombatRepository.findById(combatParticipants.characterCombatId())
                    .orElseThrow(() -> new RuntimeException("character combat not found with id: " + combatParticipants.characterCombatId()));
            newCombatParticipant.setCharacterCombat(characterCombat);
            characterCombat.setCombatParticipant(newCombatParticipant);
        }

        if (combatParticipants.enemyCombatId() != null) {
            EnemyCombat enemyCombat = enemyCombatRepository.findById(combatParticipants.enemyCombatId())
                    .orElseThrow(() -> new RuntimeException("enemy combat not found with id: " + combatParticipants.enemyCombatId()));
            newCombatParticipant.setEnemyCombat(enemyCombat);
            enemyCombat.setCombatParticipant(newCombatParticipant);
        }

        var saveCombatParticipant = combatParticipantsRepository.save(newCombatParticipant);

        return new CombatParticipantsResponseDTO(saveCombatParticipant);
    }

    @Override
    public CombatParticipantsResponseDTO update(long id, CombatParticipantsRequestDTO combatParticipants) {
        var existingCombatParticipant = combatParticipantsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("combat participant not found"));

        existingCombatParticipant.updateFromDto(combatParticipants);

        if (combatParticipants.combatId() != null) {
            Combat combat = combatRepository.findById(combatParticipants.combatId())
                    .orElseThrow(() -> new RuntimeException("combat not found with id: " + combatParticipants.combatId()));
            existingCombatParticipant.setCombat(combat);
        }

        if (combatParticipants.characterCombatId() != null) {
            CharacterCombat characterCombat = characterCombatRepository.findById(combatParticipants.characterCombatId())
                    .orElseThrow(() -> new RuntimeException("character combat not found with id: " + combatParticipants.characterCombatId()));
            existingCombatParticipant.setCharacterCombat(characterCombat);
            characterCombat.setCombatParticipant(existingCombatParticipant);
        }

        if (combatParticipants.enemyCombatId() != null) {
            EnemyCombat enemyCombat = enemyCombatRepository.findById(combatParticipants.enemyCombatId())
                    .orElseThrow(() -> new RuntimeException("enemy combat not found with id: " + combatParticipants.enemyCombatId()));
            existingCombatParticipant.setEnemyCombat(enemyCombat);
            enemyCombat.setCombatParticipant(existingCombatParticipant);
        }

        var updateCombatParticipant = combatParticipantsRepository.save(existingCombatParticipant);

        return new CombatParticipantsResponseDTO(updateCombatParticipant);
    }

    @Override
    public void deleteId(long id) {
        combatParticipantsRepository.deleteById(id);
    }
}
