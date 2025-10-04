package dev.Cursos.cursos.User;

import java.util.List;
import org.springframework.stereotype.Service;

import dev.Cursos.cursos.User.dto.UserRequestDTO;
import dev.Cursos.cursos.User.dto.UserResponseDTO;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    public UserResponseDTO getUserById(Long id) {
       return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
    public UserResponseDTO createUser(UserRequestDTO dto) {
        UserModel model = userMapper.toModel(dto);
        UserModel saved = userRepository.save(model);
        return userMapper.toResponse(saved);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public UserResponseDTO alterUser(Long id, UserRequestDTO dto) {
        UserModel existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        existing.setNome(dto.nome());
        existing.setIdade(dto.idade());
        existing.setEmail(dto.email());
        existing.setPassword(dto.password());

        UserModel updated = userRepository.save(existing);
        return userMapper.toResponse(updated);
    }
}
