package dev.Cursos.cursos.Modulo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Curso.CursoModel;
import dev.Cursos.cursos.Curso.CursoRepository;
import dev.Cursos.cursos.Modulo.dto.ModuloRequestDTO;
import dev.Cursos.cursos.Modulo.dto.ModuloResponseDTO;
import dev.Cursos.cursos.exceptions.ResourceNotFoundException;

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
    public Page<ModuloResponseDTO> getAllModulos(Pageable pageable) {
        return moduloRepository.findAll(pageable)
                .map(moduloMapper::toResponse);
    }
    
    public ModuloResponseDTO getModuloById(Long id) {
        return moduloRepository.findById(id)
                .map(moduloMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Post com ID " + id + " não encontrada."));
    }

    public ModuloResponseDTO createModulo(ModuloRequestDTO dto) {
        CursoModel curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso com ID " + dto.cursoId() + " não encontrado."));

        ModuloModel modulo = moduloMapper.toModel(dto, curso);
        ModuloModel saved = moduloRepository.save(modulo);

        return moduloMapper.toResponse(saved);
    }
    
    public void deleteModulo(Long id) {
        if(!moduloRepository.existsById(id)) {
            throw new ResourceNotFoundException("Modulo com ID " + id + " não encontrada para exclusão.");
        }
        moduloRepository.deleteById(id);
    }

}
