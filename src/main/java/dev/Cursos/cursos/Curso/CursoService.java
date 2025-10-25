package dev.Cursos.cursos.Curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Curso.dto.CursoRequestDTO;
import dev.Cursos.cursos.Curso.dto.CursoResponseDTO;
import dev.Cursos.cursos.User.UserModel;
import dev.Cursos.cursos.User.UserRepository;
import dev.Cursos.cursos.exceptions.ResourceNotFoundException;
@Service
public class CursoService {
    private CursoRepository cursoRepository;
    private CursoMapper cursoMapper;
    private UserRepository userRepository; 

    public CursoService(CursoRepository cursoRepository, CursoMapper cursoMapper, UserRepository userRepository) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
        this.userRepository = userRepository;
    }

    public Page<CursoResponseDTO> getAllCursos(Pageable pageable) {
        return cursoRepository.findAll(pageable)
                .map(cursoMapper::toResponse);
    }

    public CursoResponseDTO getCursoById(Long id){
        return cursoRepository.findById(id)
                .map(cursoMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Curso com ID " + id + " não encontrada."));
    }

    public CursoResponseDTO createCurso(CursoRequestDTO dto){
        CursoModel model = cursoMapper.toModel(dto);

        if(dto.id_user() != null){
            UserModel user = userRepository.findById(dto.id_user())
                    .orElseThrow(() -> new ResourceNotFoundException("User com ID " + dto.id_user() + " não encontrado."));
            model.getUsers().add(user);
            user.getCursos().add(model);
        }

        CursoModel saved = cursoRepository.save(model);
        return cursoMapper.toResponse(saved);
    }

    public void deleteCurso(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Curso com ID " + id + " não encontrada para exclusão.");
        }
        cursoRepository.deleteById(id);
    }

    public CursoResponseDTO patchCurso(Long id, CursoRequestDTO updatedCurso) {
    CursoModel existing = cursoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Curso com ID " + id + " não encontrado."));

    if (updatedCurso.estado() != null) {
        existing.setStatus(Enum.valueOf(StatusCurso.class, updatedCurso.estado()));
    }

    CursoModel updated = cursoRepository.save(existing);
    return cursoMapper.toResponse(updated);
    }

}
