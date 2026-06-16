package br.com.rpg_tools.rpg_helper_api.accounts.user.dto;

public record UserRequestDTO(
        String name,
        String email,
        String password
) {
}
