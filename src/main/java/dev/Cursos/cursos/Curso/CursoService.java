package dev.Cursos.cursos.Curso;

import java.util.List;
import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Curso.dto.CursoRequestDTO;
import dev.Cursos.cursos.Curso.dto.CursoResponseDTO;
import dev.Cursos.cursos.User.UserModel;
import dev.Cursos.cursos.User.UserRepository;
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

    public List<CursoResponseDTO> getCurso(){
        return cursoRepository.findAll()
        .stream()
        .map(cursoMapper::toResponse)
        .toList();
    }

    public CursoResponseDTO getCursoById(Long id){
        return cursoRepository.findById(id)
                .map(cursoMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public CursoResponseDTO createCurso(CursoRequestDTO dto){
        CursoModel model = cursoMapper.toModel(dto);

        if(dto.id_user() != null){
            UserModel user = userRepository.findById(dto.id_user())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            model.getUsers().add(user);
            user.getCursos().add(model);
        }

        CursoModel saved = cursoRepository.save(model);
        return cursoMapper.toResponse(saved);
    }

    public void deleteCurso(Long id){
        cursoRepository.deleteById(id);
    }

    public CursoResponseDTO patchCurso(Long id, CursoRequestDTO updatedCurso) {
    CursoModel existing = cursoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

    if (updatedCurso.estado() != null) {
        existing.setStatus(Enum.valueOf(StatusCurso.class, updatedCurso.estado()));
    }

    CursoModel updated = cursoRepository.save(existing);
    return cursoMapper.toResponse(updated);
    }

}
