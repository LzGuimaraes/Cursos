package dev.Cursos.cursos.Coment;

import org.springframework.stereotype.Component;
import dev.Cursos.cursos.Coment.dto.*;
import dev.Cursos.cursos.Post.PostModel;

@Component
public class CommentMapper {

    public CommentModel toModel(CommentRequestDTO dto, PostModel post) {
        CommentModel comment = new CommentModel();
        comment.setDescricao(dto.descricao());
        comment.setPost(post);
        return comment;
    }

    public CommentResponseDTO toResponse(CommentModel model) {
        return new CommentResponseDTO(
            model.getId_comment(),
            model.getDescricao(),
            model.getPost().getId_post()
        );
    }
}
