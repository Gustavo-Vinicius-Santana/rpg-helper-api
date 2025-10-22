package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CharacterMoldRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CharacterMoldResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterMoldServiceIml implements CharacterMoldService {
    @Override
    public List<CharacterMoldResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public CharacterMoldResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public CharacterMoldResponseDTO findByName(String name) {
        return null;
    }

    @Override
    public CharacterMoldResponseDTO save(CharacterMoldRequestDTO characterMold) {
        return null;
    }

    @Override
    public CharacterMoldResponseDTO update(CharacterMoldRequestDTO characterMold) {
        return null;
    }

    @Override
    public void deleteId(long id) {

    }
}
