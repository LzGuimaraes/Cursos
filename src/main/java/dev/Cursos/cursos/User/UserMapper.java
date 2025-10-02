package dev.Cursos.cursos.User;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserModel map(UserDTO userDTO) {
        UserModel userModel = new UserModel();
        userModel.setNome(userDTO.getNome());
        userModel.setIdade(userDTO.getIdade());
        userModel.setEmail(userDTO.getEmail());
        userModel.setPassword(userDTO.getPassword());
        return userModel;
    }

    public UserDTO map(UserModel userModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId_user(userModel.getId_user());
        userDTO.setNome(userModel.getNome());
        userDTO.setIdade(userModel.getIdade());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setPassword(userModel.getPassword());
        return userDTO;
    }
}
