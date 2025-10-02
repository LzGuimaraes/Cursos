package dev.Cursos.cursos.Curso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import dev.Cursos.cursos.User.UserModel;

import java.util.List;

import dev.Cursos.cursos.Post.PostModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private Long id_curso;
    private String nome;
    private String estado;
    private String descricao;
    private List<UserModel> user;
    private List<PostModel> post;
}
