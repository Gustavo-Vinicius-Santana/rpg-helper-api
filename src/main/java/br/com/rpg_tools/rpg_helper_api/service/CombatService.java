package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CombatResponseDTO;

import java.util.List;

public interface CombatService {
    List<CombatResponseDTO> findAll();

    CombatResponseDTO findById(Long id);

    CombatResponseDTO findByName(String name);

    CombatResponseDTO save(CombatRequestDTO combat);

    CombatResponseDTO update(long id, CombatRequestDTO combat);

    void deleteId(long id);
}
