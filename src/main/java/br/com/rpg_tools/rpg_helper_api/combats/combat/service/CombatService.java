package br.com.rpg_tools.rpg_helper_api.combats.combat.service;

import br.com.rpg_tools.rpg_helper_api.combats.combat.dto.CombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combat.dto.CombatResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CombatService {
    Page<CombatResponseDTO> findAll(Pageable pageable);

    CombatResponseDTO findById(Long id);

    Page<CombatResponseDTO> findByName(String name, Pageable pageable);

    CombatResponseDTO save(CombatRequestDTO combat);

    CombatResponseDTO update(long id, CombatRequestDTO combat);

    void deleteId(long id);
}
