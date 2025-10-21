package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.EnemyCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.EnemyCombatResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnemyCombatServiceIml implements EnemyCombatService{
    @Override
    public List<EnemyCombatResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public EnemyCombatResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public EnemyCombatResponseDTO findByName(String name) {
        return null;
    }

    @Override
    public EnemyCombatResponseDTO save(EnemyCombatRequestDTO combat) {
        return null;
    }

    @Override
    public EnemyCombatResponseDTO update(long id, EnemyCombatRequestDTO combat) {
        return null;
    }

    @Override
    public void deleteId(long id) {

    }
}
