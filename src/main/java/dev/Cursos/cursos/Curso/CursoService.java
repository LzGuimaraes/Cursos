package dev.Cursos.cursos.Curso;

import java.util.List;
import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Curso.dto.CursoRequestDTO;
import dev.Cursos.cursos.Curso.dto.CursoResponseDTO;

@Service
public class CursoService {
    private CursoRepository cursoRepository;
    private CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }
    public List<CursoResponseDTO> getCurso(){
        return cursoRepository.findAll()
        .stream()
        .map(cursoMapper::toResponse)
        .toList();
    }

    public CursoResponseDTO getCursoById(Long id){
        return cursoRepository.findById(id).map(cursoMapper::toResponse).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }
    public CursoResponseDTO createCurso(CursoRequestDTO dto){
        CursoModel model = cursoMapper.toModel(dto);
        CursoModel saved = cursoRepository.save(model);
        return cursoMapper.toResponse(saved);
    }
    public void deleteCurso(Long id){
        cursoRepository.deleteById(id);
    }
    public CursoResponseDTO alterCurso(Long id, CursoRequestDTO dto){
        CursoModel existing = cursoRepository.findById(id).orElseThrow(()-> new RuntimeException("Curso não encontrado "));
        existing.setNome(dto.nome());
        existing.setDescricao(dto.descricao());
            CursoModel cursoSaved = cursoRepository.save(existing);
            return cursoMapper.toResponse(cursoSaved);
        
    }
}
