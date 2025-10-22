package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.EnemyCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.EnemyCombatResponseDTO;

import java.util.List;

public interface EnemyCombatService {
    List<EnemyCombatResponseDTO> findAll();

    EnemyCombatResponseDTO findById(Long id);

    EnemyCombatResponseDTO findByName(String name);

    EnemyCombatResponseDTO save(EnemyCombatRequestDTO combat);

    EnemyCombatResponseDTO update(long id, EnemyCombatRequestDTO combat);

    void deleteId(long id);
}
