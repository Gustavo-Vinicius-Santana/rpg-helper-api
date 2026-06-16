package br.com.rpg_tools.rpg_helper_api.combats.characterCombat.service;

import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.dto.CharacterCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.dto.CharacterCombatResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterCombatService {
    Page<CharacterCombatResponseDTO> findAll(Pageable pageable);

    CharacterCombatResponseDTO findById(Long id);

    Page<CharacterCombatResponseDTO> findByName(String name, Pageable pageable);

    CharacterCombatResponseDTO save(CharacterCombatRequestDTO characterCombat);

    CharacterCombatResponseDTO update(long id, CharacterCombatRequestDTO characterCombat);

    void deleteId(long id);
}
