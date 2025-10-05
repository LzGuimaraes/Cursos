package dev.Cursos.cursos.User;

import java.util.List;
import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Curso.CursoModel;
import dev.Cursos.cursos.Curso.CursoRepository;
import dev.Cursos.cursos.User.dto.UserRequestDTO;
import dev.Cursos.cursos.User.dto.UserResponseDTO;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private CursoRepository cursoRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper, CursoRepository cursoRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.cursoRepository = cursoRepository;
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
    UserModel user = userMapper.toModel(dto);

    if (dto.cursoIds() != null && !dto.cursoIds().isEmpty()) {
        List<CursoModel> cursos = cursoRepository.findAllById(dto.cursoIds());
        user.setCursos(cursos);

        for (CursoModel curso : cursos) {
            if (!curso.getUsers().contains(user)) {
                curso.getUsers().add(user);
            }
        }
    }
    UserModel saved = userRepository.save(user);

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
