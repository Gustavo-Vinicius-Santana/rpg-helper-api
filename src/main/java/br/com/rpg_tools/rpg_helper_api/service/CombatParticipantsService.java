package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CombatParticipantsRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CombatParticipantsResponseDTO;

import java.util.List;

public interface CombatParticipantsService {
    List<CombatParticipantsResponseDTO> findAll();

    CombatParticipantsResponseDTO findById(Long id);

    CombatParticipantsResponseDTO findByName(String name);

    CombatParticipantsResponseDTO save(CombatParticipantsRequestDTO combatParticipants);

    CombatParticipantsResponseDTO update(long id, CombatParticipantsRequestDTO combatParticipants);

    void deleteId(long id);
}
