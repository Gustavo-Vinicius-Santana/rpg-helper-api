package br.com.rpg_tools.rpg_helper_api.service;

import br.com.rpg_tools.rpg_helper_api.dto.CharacterMoldRequestDTO;
import br.com.rpg_tools.rpg_helper_api.dto.CharacterMoldResponseDTO;

import java.util.List;

public interface CharacterMoldService {
    List<CharacterMoldResponseDTO> findAll();

    CharacterMoldResponseDTO findById(Long id);

    CharacterMoldResponseDTO findByName(String name);

    CharacterMoldResponseDTO save(CharacterMoldRequestDTO characterMold);

    CharacterMoldResponseDTO update(CharacterMoldRequestDTO characterMold);

    void deleteId(long id);
}
