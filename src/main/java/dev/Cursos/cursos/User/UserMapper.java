package dev.Cursos.cursos.User;

import org.springframework.stereotype.Component;
import dev.Cursos.cursos.User.dto.UserRequestDTO;
import dev.Cursos.cursos.User.dto.UserResponseDTO;

@Component
public class UserMapper {

    public UserModel toModel(UserRequestDTO dto) {
        UserModel model = new UserModel();
        model.setNome(dto.nome());
        model.setIdade(dto.idade());
        model.setEmail(dto.email());
        model.setPassword(dto.password());
        return model;
    }

    public UserResponseDTO toResponse(UserModel model) {
        return new UserResponseDTO(
            model.getId_user(),
            model.getNome(),
            model.getIdade(),
            model.getEmail(),
            model.getCursos()
        );
    }
}
