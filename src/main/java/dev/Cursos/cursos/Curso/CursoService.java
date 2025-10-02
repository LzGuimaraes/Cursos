package dev.Cursos.cursos.Curso;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CursoService {
    private CursoRepository cursoRepository;
    private CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }
    public List<CursoDTO> getCurso(){
        List<CursoModel> cursos = cursoRepository.findAll();
        return cursos.stream().map(cursoMapper::map).collect(Collectors.toList());
    }

    public CursoDTO getCursoById(Long id){
        Optional<CursoModel> cursoById = cursoRepository.findById(id);
        return cursoById.map(cursoMapper::map).orElse(null);
    }
    public CursoDTO createCurso(CursoDTO curso){
        CursoModel cursoModel = cursoMapper.map(curso);
        cursoModel = cursoRepository.save(cursoModel);
        return cursoMapper.map(cursoModel);
    }
    public void deleteCurso(Long id){
        cursoRepository.deleteById(id);
    }
    public CursoDTO alterCurso(Long id, CursoDTO updatedCurso){
        Optional<CursoModel> existingCurso = cursoRepository.findById(id);
        if (existingCurso.isPresent()) {
            CursoModel cursoUpdated = cursoMapper.map(updatedCurso);
            cursoUpdated.setId_curso(id);
            CursoModel cursoSaved = cursoRepository.save(cursoUpdated);
            return cursoMapper.map(cursoSaved);
        }
        return null;
    }
}
