package br.com.rpg_tools.rpg_helper_api.repository;

import br.com.rpg_tools.rpg_helper_api.template.characterTemplate.model.CharacterTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterTemplateRepository extends JpaRepository<CharacterTemplate, Long> {
    Page<CharacterTemplate> findByNameContaining(String name, Pageable pageable);
}
