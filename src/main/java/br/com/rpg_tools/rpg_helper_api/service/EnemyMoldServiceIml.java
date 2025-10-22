package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.EnemyMoldRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.EnemyMoldResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnemyMoldServiceIml implements EnemyMoldService {
    @Override
    public List<EnemyMoldResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public EnemyMoldResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public EnemyMoldResponseDTO findByName(String name) {
        return null;
    }

    @Override
    public EnemyMoldResponseDTO save(EnemyMoldRequestDTO combat) {
        return null;
    }

    @Override
    public EnemyMoldResponseDTO update(long id, EnemyMoldRequestDTO combat) {
        return null;
    }

    @Override
    public void deleteId(long id) {

    }
}
