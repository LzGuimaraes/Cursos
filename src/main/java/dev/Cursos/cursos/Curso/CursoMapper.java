package dev.Cursos.cursos.Curso;

import org.springframework.stereotype.Component;

import dev.Cursos.cursos.Curso.dto.CursoRequestDTO;
import dev.Cursos.cursos.Curso.dto.CursoResponseDTO;

@Component
public class CursoMapper {

    public CursoModel toModel(CursoRequestDTO dto) {
        CursoModel model = new CursoModel();
        model.setNome(dto.nome());
        model.setDescricao(dto.descricao());
        model.setStatus(StatusCurso.valueOf(dto.estado()));
        return model;
    }

    public CursoResponseDTO toResponse(CursoModel model) {
        return new CursoResponseDTO(
            model.getId_curso(),
            model.getNome(),
            model.getStatus(),
            model.getDescricao(),
            model.getUsers(),
            model.getPosts()
        );
    }
}
