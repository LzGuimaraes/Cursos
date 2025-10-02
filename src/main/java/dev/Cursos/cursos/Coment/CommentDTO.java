package dev.Cursos.cursos.Coment;

import dev.Cursos.cursos.Post.PostModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long id_comment;
    private String descricao;
    private PostModel post;
}
