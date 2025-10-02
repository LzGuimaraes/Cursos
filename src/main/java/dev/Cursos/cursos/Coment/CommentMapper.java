package dev.Cursos.cursos.Coment;

import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public CommentModel map(CommentDTO commentDTO) {
        CommentModel commentModel = new CommentModel();
        commentModel.setDescricao(commentDTO.getDescricao());
        commentModel.setPost(commentDTO.getPost());
        return commentModel;
    }

    public CommentDTO map(CommentModel commentModel) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId_comment(commentModel.getId_comment());
        commentDTO.setDescricao(commentModel.getDescricao());
        commentDTO.setPost(commentModel.getPost());
        return commentDTO;
    }
}
