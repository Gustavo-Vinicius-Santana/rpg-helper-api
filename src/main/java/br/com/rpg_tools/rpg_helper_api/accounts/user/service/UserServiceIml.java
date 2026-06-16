package br.com.rpg_tools.rpg_helper_api.accounts.user.service;

import br.com.rpg_tools.rpg_helper_api.accounts.user.dto.UserRequestDTO;
import br.com.rpg_tools.rpg_helper_api.accounts.user.dto.UserResponseDTO;
import br.com.rpg_tools.rpg_helper_api.accounts.user.model.User;
import br.com.rpg_tools.rpg_helper_api.accounts.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceIml implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<UserResponseDTO> findAll(Pageable pagination) {
        return userRepository.findAll(pagination)
                .map(UserResponseDTO::new);
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return userRepository.findById(id)
                .map(UserResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public Page<UserResponseDTO> findByName(String name, Pageable pagination) {
        return userRepository.findByNameContaining(name, pagination)
                .map(UserResponseDTO::new);
    }

    @Override
    public UserResponseDTO save(UserRequestDTO user) {
        var newUser = User.fromDto(user);

        var savedUser = userRepository.save(newUser);

        return new UserResponseDTO(savedUser);
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO user) {
        var existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.updateFromDto(user);

        var updatedUser = userRepository.save(existingUser);

        return new UserResponseDTO(updatedUser);
    }

    @Override
    public void deleteId(long id) {
        userRepository.deleteById(id);
    }
}