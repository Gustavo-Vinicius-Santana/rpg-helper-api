package br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.service;

import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.dto.EnemyCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.enemyCombat.dto.EnemyCombatResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnemyCombatService {
    Page<EnemyCombatResponseDTO> findAll(Pageable pageable);

    EnemyCombatResponseDTO findById(Long id);

    Page<EnemyCombatResponseDTO> findByName(String name, Pageable pageable);

    EnemyCombatResponseDTO save(EnemyCombatRequestDTO combat);

    EnemyCombatResponseDTO update(long id, EnemyCombatRequestDTO combat);

    void deleteId(long id);
}
