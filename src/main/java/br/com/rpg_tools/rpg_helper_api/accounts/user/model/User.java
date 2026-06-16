package br.com.rpg_tools.rpg_helper_api.accounts.user.model;

import br.com.rpg_tools.rpg_helper_api.accounts.user.dto.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public static User fromDto(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        return user;
    }

    public void updateFromDto(UserRequestDTO dto){
        this.setName(dto.name());
        this.setEmail(dto.email());
        this.setPassword(dto.password());
    }
}