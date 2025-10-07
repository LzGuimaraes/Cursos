package dev.Cursos.cursos.Modulo;

import org.springframework.stereotype.Component;

import dev.Cursos.cursos.Curso.CursoModel;
import dev.Cursos.cursos.Modulo.dto.ModuloRequestDTO;
import dev.Cursos.cursos.Modulo.dto.ModuloResponseDTO;

@Component
public class ModuloMapper {

    public ModuloModel toModel(ModuloRequestDTO dto, CursoModel curso) {
        ModuloModel modulo = new ModuloModel();
        modulo.setTitulo(dto.titulo());
        modulo.setDescricao(dto.descricao());
        modulo.setOrdem(dto.ordem());
        modulo.setCurso(curso);
        return modulo;
    }
    public ModuloResponseDTO toResponse(ModuloModel model) {
        return new ModuloResponseDTO(
            model.getId_modulo(),
            model.getTitulo(),
            model.getDescricao(),
            model.getOrdem(),
            model.getCurso().getId_curso()
        );
    }
}
