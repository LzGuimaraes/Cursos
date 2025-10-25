package dev.Cursos.cursos.User;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Curso.CursoModel;
import dev.Cursos.cursos.Curso.CursoRepository;
import dev.Cursos.cursos.User.dto.UserPatchDTO;
import dev.Cursos.cursos.User.dto.UserRequestDTO;
import dev.Cursos.cursos.User.dto.UserResponseDTO;
import dev.Cursos.cursos.exceptions.ResourceNotFoundException;

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

    public Page<UserResponseDTO> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::toResponse);
    }

    public UserResponseDTO getUserById(Long id) {
       return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("User com ID " + id + " não encontrada."));
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
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User com ID " + id + " não encontrada para exclusão.");
        }
        userRepository.deleteById(id);
    }

    public UserResponseDTO patchUser(Long id, UserPatchDTO dto) {
        UserModel existing = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User com ID " + id + " não encontrada."));
    
    if (dto.nome() != null) existing.setNome(dto.nome());
    if (dto.idade() != null) existing.setIdade(dto.idade());
    if (dto.email() != null) existing.setEmail(dto.email());
    if (dto.password() != null) existing.setPassword(dto.password());

    if (dto.cursoIds() != null && !dto.cursoIds().isEmpty()) {
        List<CursoModel> cursos = cursoRepository.findAllById(dto.cursoIds());
        existing.setCursos(cursos);

        for (CursoModel curso : cursos) {
            if (!curso.getUsers().contains(existing)) {
                curso.getUsers().add(existing);
            }
        }
    }

    UserModel updated = userRepository.save(existing);
    return userMapper.toResponse(updated);
    }
}
