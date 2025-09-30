package dev.Cursos.cursos.Curso;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CursoService {
    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    public List<CursoModel> getCurso(){
        return cursoRepository.findAll();
    }

    public CursoModel getCursoById(Long id){
        Optional<CursoModel> curso = cursoRepository.findById(id);
        return curso.orElse(null);
    }
}
