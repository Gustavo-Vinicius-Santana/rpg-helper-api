package br.com.rpg_tools.rpg_helper_api.repository;

import br.com.rpg_tools.rpg_helper_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}