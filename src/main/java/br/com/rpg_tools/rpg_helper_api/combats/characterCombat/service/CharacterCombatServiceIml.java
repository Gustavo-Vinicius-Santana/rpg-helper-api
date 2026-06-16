package br.com.rpg_tools.rpg_helper_api.combats.characterCombat.service;

import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.dto.CharacterCombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.dto.CharacterCombatResponseDTO;
import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.model.CharacterCombat;
import br.com.rpg_tools.rpg_helper_api.combats.characterCombat.repository.CharacterCombatRepository;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.model.CombatParticipant;
import br.com.rpg_tools.rpg_helper_api.combats.combatParticipants.repository.CombatParticipantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterCombatServiceIml implements CharacterCombatService {

    private final CharacterCombatRepository characterCombatRepository;
    private final CombatParticipantsRepository combatParticipantsRepository;

    @Override
    public Page<CharacterCombatResponseDTO> findAll(Pageable pagination) {
        return characterCombatRepository.findAll(pagination)
                .map(CharacterCombatResponseDTO::new);
    }

    @Override
    public CharacterCombatResponseDTO findById(Long id) {
        return characterCombatRepository.findById(id)
                .map(CharacterCombatResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("character combat not found with id: " + id));
    }

    @Override
    public Page<CharacterCombatResponseDTO> findByName(String name, Pageable pageable) {
        return characterCombatRepository.findByNameContainingIgnoreCase(name, pageable)
                .map(CharacterCombatResponseDTO::new);
    }

    @Override
    public CharacterCombatResponseDTO save(CharacterCombatRequestDTO characterCombat) {
        var newCharacterCombat = CharacterCombat.fromDto(characterCombat);

        if (characterCombat.combatParticipantId() != null) {
            CombatParticipant combatParticipant = combatParticipantsRepository.findById(characterCombat.combatParticipantId())
                    .orElseThrow(() -> new RuntimeException("combat participant not found with id: " + characterCombat.combatParticipantId()));
            newCharacterCombat.setCombatParticipant(combatParticipant);
        }

        var saveCharacterCombat = characterCombatRepository.save(newCharacterCombat);

        return new CharacterCombatResponseDTO(saveCharacterCombat);
    }

    @Override
    public CharacterCombatResponseDTO update(long id, CharacterCombatRequestDTO characterCombat) {
        var existingCharacterCombat = characterCombatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("character combat not found"));

        existingCharacterCombat.updateFromDto(characterCombat);

        if (characterCombat.combatParticipantId() != null) {
            CombatParticipant combatParticipant = combatParticipantsRepository.findById(characterCombat.combatParticipantId())
                    .orElseThrow(() -> new RuntimeException("combat participant not found with id: " + characterCombat.combatParticipantId()));
            existingCharacterCombat.setCombatParticipant(combatParticipant);
        }

        var updateCharacterCombat = characterCombatRepository.save(existingCharacterCombat);

        return new CharacterCombatResponseDTO(updateCharacterCombat);
    }

    @Override
    public void deleteId(long id) {
        characterCombatRepository.deleteById(id);
    }
}
