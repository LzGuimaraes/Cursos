package dev.Cursos.cursos.Post;

import org.springframework.stereotype.Component;

import dev.Cursos.cursos.Curso.CursoModel;
import dev.Cursos.cursos.Post.dto.PostRequestDTO;
import dev.Cursos.cursos.Post.dto.PostResponseDTO;

@Component
public class PostMapper {

    public PostModel toModel(PostRequestDTO dto, CursoModel curso) {
        PostModel model = new PostModel();
        model.setTitulo(dto.titulo());
        model.setDescricao(dto.descricao());
        model.setCurso(curso);
        return model;
    }

    public PostResponseDTO toResponse(PostModel model) {
        return new PostResponseDTO(
            model.getId_post(),
            model.getTitulo(),
            model.getDescricao(),
            model.getCurso().getId_curso()
        );
    }
}

