package br.com.rpg_tools.rpg_helper_api.accounts.user.dto;

import br.com.rpg_tools.rpg_helper_api.accounts.user.model.User;

public record UserResponseDTO(
        Long id,
        String name,
        String email
) {
    public UserResponseDTO(User user){
        this(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
