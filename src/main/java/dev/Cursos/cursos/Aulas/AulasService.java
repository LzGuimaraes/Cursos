package dev.Cursos.cursos.Aulas;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Aulas.dto.AulasRequestDTO;
import dev.Cursos.cursos.Aulas.dto.AulasResponseDTO;
import dev.Cursos.cursos.Modulo.ModuloModel;
import dev.Cursos.cursos.Modulo.ModuloRepository;

@Service
public class AulasService {

    private AulasRepository aulasRepository;
    private ModuloRepository moduloRepository;
    private AulasMapper aulasMapper;

    public AulasService(AulasRepository aulasRepository, ModuloRepository moduloRepository, AulasMapper aulasMapper) {
        this.aulasRepository = aulasRepository;
        this.moduloRepository = moduloRepository;
        this.aulasMapper = aulasMapper;
    }

    public List<AulasResponseDTO> getAllAulas(){
        return aulasRepository.findAll()
            .stream()
            .map(aulasMapper::toResponse)
            .toList();
    }

    public AulasResponseDTO getAulasById(Long id) {
        return aulasRepository.findById(id)
        .map(aulasMapper::toResponse)
        .orElseThrow(()-> new RuntimeException("Aula não encontrada"));
    }

    public AulasResponseDTO createAulas(AulasRequestDTO dto) {
        ModuloModel modulo = moduloRepository.findById(dto.id_modulo())
                .orElseThrow(() -> new RuntimeException("Módulo não encontrado."));

        AulasModel aulas = aulasMapper.toModel(dto, modulo);
        AulasModel saved = aulasRepository.save(aulas);

        return aulasMapper.toResponse(saved);
    }
    public void deleteAulas(Long id) {
        aulasRepository.deleteById(id);
    }
}
