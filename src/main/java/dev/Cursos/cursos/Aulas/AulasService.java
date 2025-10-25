package dev.Cursos.cursos.Aulas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.Cursos.cursos.Aulas.dto.AulasRequestDTO;
import dev.Cursos.cursos.Aulas.dto.AulasResponseDTO;
import dev.Cursos.cursos.Modulo.ModuloModel;
import dev.Cursos.cursos.Modulo.ModuloRepository;
import dev.Cursos.cursos.exceptions.ResourceNotFoundException;

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

    public Page<AulasResponseDTO> getAllAulas(Pageable pageable) {
        return aulasRepository.findAll(pageable)
                .map(aulasMapper::toResponse);
    }


    public AulasResponseDTO getAulasById(Long id) {
        return aulasRepository.findById(id)
        .map(aulasMapper::toResponse)
        .orElseThrow(()-> new ResourceNotFoundException("Aula com ID " + id + " não encontrada."));
    }

    public AulasResponseDTO createAulas(AulasRequestDTO dto) {
        ModuloModel modulo = moduloRepository.findById(dto.id_modulo())
                .orElseThrow(() -> new ResourceNotFoundException("Módulo com ID " + dto.id_modulo() + " não encontrado."));

        AulasModel aulas = aulasMapper.toModel(dto, modulo);
        AulasModel saved = aulasRepository.save(aulas);

        return aulasMapper.toResponse(saved);
    }
    public void deleteAulas(Long id) {
        if (!aulasRepository.existsById(id)) {
            throw new ResourceNotFoundException("Aula com ID " + id + " não encontrada para exclusão.");
        }
        aulasRepository.deleteById(id);
    }
}
