package br.com.rpg_tools.rpg_helper_api.accounts.user.service;

import br.com.rpg_tools.rpg_helper_api.accounts.user.dto.UserRequestDTO;
import br.com.rpg_tools.rpg_helper_api.accounts.user.dto.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserResponseDTO> findAll(Pageable pagination);

    UserResponseDTO findById(Long id);

    Page<UserResponseDTO> findByName(String name, Pageable pagination);

    UserResponseDTO save(UserRequestDTO user);

    UserResponseDTO update(Long id, UserRequestDTO user);

    void deleteId(long id);
}
