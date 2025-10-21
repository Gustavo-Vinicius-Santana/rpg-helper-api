package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CombatResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CombatServiceIml implements CombatService{
    @Override
    public List<CombatResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public CombatResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public CombatResponseDTO findByName(String name) {
        return null;
    }

    @Override
    public CombatResponseDTO save(CombatRequestDTO combat) {
        return null;
    }

    @Override
    public CombatResponseDTO update(long id, CombatRequestDTO combat) {
        return null;
    }

    @Override
    public void deleteId(long id) {

    }
}
