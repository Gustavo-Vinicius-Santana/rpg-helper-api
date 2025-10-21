package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.EnemyCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.EnemyCombatResponseDTO;
import br.com.rpg_tools.rpg_helper_api.dto.EnemyMoldRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.EnemyMoldResponseDTO;

import java.util.List;

public interface EnemyMoldService {
    List<EnemyMoldResponseDTO> findAll();

    EnemyMoldResponseDTO findById(Long id);

    EnemyMoldResponseDTO findByName(String name);

    EnemyMoldResponseDTO save(EnemyMoldRequestDTO combat);

    EnemyMoldResponseDTO update(long id, EnemyMoldRequestDTO combat);

    void deleteId(long id);
}
