package br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.service;

import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.dto.CombatParticipantsRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.dto.CombatParticipantsResponseDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.ParticipantType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CombatParticipantsService {
    Page<CombatParticipantsResponseDTO> findAll(Pageable pageable);

    CombatParticipantsResponseDTO findById(Long id);

    Page<CombatParticipantsResponseDTO> findByType(ParticipantType type, Pageable pageable);

    Page<CombatParticipantsResponseDTO> findByIdCombat(Long id, Pageable pageable);

    CombatParticipantsResponseDTO save(CombatParticipantsRequestDTO combatParticipants);

    CombatParticipantsResponseDTO update(long id, CombatParticipantsRequestDTO combatParticipants);

    void deleteId(long id);
}
