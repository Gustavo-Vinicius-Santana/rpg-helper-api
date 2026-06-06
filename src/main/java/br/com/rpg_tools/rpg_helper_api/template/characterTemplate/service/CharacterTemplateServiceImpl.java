package br.com.rpg_tools.rpg_helper_api.template.characterTemplate.service;

import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.dto.CharacterTemplateRequestDTO;
import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.dto.CharacterTemplateResponseDTO;
import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.model.CharacterTemplate;
import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.repository.CharacterTemplateRepository;
import br.com.rpg_tools.rpg_helper_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterTemplateServiceImpl implements CharacterTemplateService {
    
    private final CharacterTemplateRepository characterTemplateRepository;
    private final UserRepository userRepository;
    
    @Override
    public Page<CharacterTemplateResponseDTO> findAll(Pageable pagination) {
        return characterTemplateRepository.findAll(pagination)
                .map(CharacterTemplateResponseDTO::new);
    }

    @Override
    public CharacterTemplateResponseDTO findById(Long id) {
        return characterTemplateRepository.findById(id)
                .map(CharacterTemplateResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Character template not found with id: " + id));
    }

    @Override
    public Page<CharacterTemplateResponseDTO> findByName(String name, Pageable pagination) {
        return characterTemplateRepository
                .findByNameContaining(name, pagination)
                .map(CharacterTemplateResponseDTO::new);
    }

    @Override
    public CharacterTemplateResponseDTO save(CharacterTemplateRequestDTO characterTemplate) {
        var character = CharacterTemplate.fromDto(characterTemplate);

        var saveCharacter = characterTemplateRepository.save(character);

        return new CharacterTemplateResponseDTO(saveCharacter);
    }

    @Override
    public CharacterTemplateResponseDTO update(Long id, CharacterTemplateRequestDTO characterTemplateRequest) {
        var existingCharacter = characterTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Character template not found"));

        existingCharacter.updateFromDto(characterTemplateRequest);

        var updatedCharacter = characterTemplateRepository.save(existingCharacter);

        return new CharacterTemplateResponseDTO(updatedCharacter);
    }

    @Override
    public void deleteId(long id) {
        characterTemplateRepository.deleteById(id);
    }
}
