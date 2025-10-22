package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CombatParticipantsRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CombatParticipantsResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CombatParticipantsServiceIml implements CombatParticipantsService {
    @Override
    public List<CombatParticipantsResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public CombatParticipantsResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public CombatParticipantsResponseDTO findByName(String name) {
        return null;
    }

    @Override
    public CombatParticipantsResponseDTO save(CombatParticipantsRequestDTO combatParticipants) {
        return null;
    }

    @Override
    public CombatParticipantsResponseDTO update(long id, CombatParticipantsRequestDTO combatParticipants) {
        return null;
    }

    @Override
    public void deleteId(long id) {

    }
}
