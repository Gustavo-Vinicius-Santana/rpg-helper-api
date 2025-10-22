package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CharacterCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CharacterCombatResponseDTO;

import java.util.List;

public interface CharacterCombatService {
    List<CharacterCombatResponseDTO> findAll();

    CharacterCombatResponseDTO findById(Long id);

    CharacterCombatResponseDTO findByName(String name);

    CharacterCombatResponseDTO save(CharacterCombatRequestDTO characterCombat);

    CharacterCombatResponseDTO update(CharacterCombatRequestDTO characterCombat);

    void deleteId(long id);
}
