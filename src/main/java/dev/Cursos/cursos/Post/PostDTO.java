package dev.Cursos.cursos.Post;

import dev.Cursos.cursos.Curso.CursoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Long id_post;
    private String titulo;
    private String descricao;
    private CursoModel curso;
}
