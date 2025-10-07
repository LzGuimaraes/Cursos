package dev.Cursos.cursos.Modulo;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Curso.CursoModel;
import dev.Cursos.cursos.Curso.CursoRepository;
import dev.Cursos.cursos.Modulo.dto.ModuloRequestDTO;
import dev.Cursos.cursos.Modulo.dto.ModuloResponseDTO;

@Service
public class ModuloService {
    private ModuloRepository moduloRepository;
    private CursoRepository cursoRepository;
    private ModuloMapper moduloMapper;

    public ModuloService(ModuloRepository moduloRepository, CursoRepository cursoRepository, ModuloMapper moduloMapper){
        this.moduloRepository = moduloRepository;
        this.cursoRepository = cursoRepository;
        this.moduloMapper = moduloMapper;
    }

    public List<ModuloResponseDTO> getAllModulos(){
        return moduloRepository.findAll()
                .stream()
                .map(moduloMapper::toResponse)
                .toList();
    }
    
    public ModuloResponseDTO getModuloById(Long id) {
        return moduloRepository.findById(id)
                .map(moduloMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Modulo não encontrado."));
    }

    public ModuloResponseDTO createModulo(ModuloRequestDTO dto) {
        CursoModel curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado."));

        ModuloModel modulo = moduloMapper.toModel(dto, curso);
        ModuloModel saved = moduloRepository.save(modulo);

        return moduloMapper.toResponse(saved);
    }
    
    public void deleteModulo(Long id) {
        moduloRepository.deleteById(id);
    }

}
