package br.com.rpg_tools.rpg_helper_api.accounts.user.controller;

import br.com.rpg_tools.rpg_helper_api.accounts.user.dto.UserRequestDTO;
import br.com.rpg_tools.rpg_helper_api.accounts.user.dto.UserResponseDTO;
import br.com.rpg_tools.rpg_helper_api.accounts.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> findAll(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pagination
    ) {
        return ResponseEntity.ok(userService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Page<UserResponseDTO>> findByName(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pagination,
            @PathVariable("name") String name
    ) {
        return ResponseEntity.ok(userService.findByName(name, pagination));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> save(
            @Valid @RequestBody UserRequestDTO userRequest
    ) {
        UserResponseDTO savedUser = userService.save(userRequest);

        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(
            @PathVariable("id") long id,
            @Valid @RequestBody UserRequestDTO userRequest
    ) {
        UserResponseDTO userUpdate = userService.update(id, userRequest);

        return ResponseEntity.ok(userUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        userService.deleteId(id);

        return ResponseEntity.noContent().build();
    }
}