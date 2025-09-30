package dev.Cursos.cursos.Curso;

import java.util.List;

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
}
