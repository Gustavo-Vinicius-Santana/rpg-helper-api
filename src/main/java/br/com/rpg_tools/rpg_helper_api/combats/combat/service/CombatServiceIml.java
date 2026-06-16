package br.com.rpg_tools.rpg_helper_api.combats.combat.service;

import br.com.rpg_tools.rpg_helper_api.campaigns.campaign.dto.CampaignResponseDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combat.dto.CombatRequestDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combat.dto.CombatResponseDTO;
import br.com.rpg_tools.rpg_helper_api.combats.combat.model.Combat;
import br.com.rpg_tools.rpg_helper_api.combats.combat.repository.CombatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CombatServiceIml implements CombatService{

    private final CombatRepository combatRepository;

    @Override
    public Page<CombatResponseDTO> findAll(Pageable pagination) {
        return combatRepository.findAll(pagination)
                .map(CombatResponseDTO::new);
    }

    @Override
    public CombatResponseDTO findById(Long id) {
        return combatRepository.findById(id)
                .map(CombatResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("combat not found with id: " + id));
    }

    @Override
    public Page<CombatResponseDTO> findByName(String name, Pageable pageable) {
        return combatRepository.findByNameContainingIgnoreCase(name, pageable)
                .map(CombatResponseDTO::new);
    }

    @Override
    public CombatResponseDTO save(CombatRequestDTO combat) {
        var newCombat = Combat.fromDto(combat);

        var saveCombat = combatRepository.save(newCombat);

        return new CombatResponseDTO(saveCombat);
    }

    @Override
    public CombatResponseDTO update(long id, CombatRequestDTO combat) {
        var existingCombat = combatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("combat not found"));

        existingCombat.updateFromDto(combat);

        var updateCombat = combatRepository.save(existingCombat);

        return new CombatResponseDTO(updateCombat);
    }

    @Override
    public void deleteId(long id) {
        combatRepository.deleteById(id);
    }
}
