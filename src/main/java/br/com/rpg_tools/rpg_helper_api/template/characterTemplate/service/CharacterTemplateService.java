package br.com.rpg_tools.rpg_helper_api.template.characterTemplate.service;

import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.dto.CharacterTemplateRequestDTO;
import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.dto.CharacterTemplateResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterTemplateService {
    Page<CharacterTemplateResponseDTO> findAll(Pageable pagination);

    CharacterTemplateResponseDTO findById(Long id);

    Page<CharacterTemplateResponseDTO> findByName(String name, Pageable pagination);

    CharacterTemplateResponseDTO save(CharacterTemplateRequestDTO characterTemplate);

    CharacterTemplateResponseDTO update(Long id, CharacterTemplateRequestDTO characterTemplate);

    void deleteId(long id);
}
