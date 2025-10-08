package dev.Cursos.cursos.Aulas;

import dev.Cursos.cursos.Aulas.dto.AulasRequestDTO;
import dev.Cursos.cursos.Aulas.dto.AulasResponseDTO;
import dev.Cursos.cursos.Modulo.ModuloModel;

public class AulasMapper {

    public AulasModel toModel(AulasRequestDTO dto, ModuloModel modulo) {
        AulasModel aulas = new AulasModel();
        aulas.setTitulo(dto.titulo());
        return aulas;
    }
    public AulasResponseDTO toResponse(AulasModel model) {
        return new AulasResponseDTO(
            model.getId_aula(),
            model.getTitulo(),
            model.getDescricao(),
            model.getRecursos(),
            model.getModulo().getId_modulo()
        );
    } 
}
