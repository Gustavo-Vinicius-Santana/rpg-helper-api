package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CharacterCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CharacterCombatResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterCombatServiceIml implements CharacterCombatService {
    @Override
    public List<CharacterCombatResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public CharacterCombatResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public CharacterCombatResponseDTO findByName(String name) {
        return null;
    }

    @Override
    public CharacterCombatResponseDTO save(CharacterCombatRequestDTO characterCombat) {
        return null;
    }

    @Override
    public CharacterCombatResponseDTO update(CharacterCombatRequestDTO characterCombat) {
        return null;
    }

    @Override
    public void deleteId(long id) {

    }
}
