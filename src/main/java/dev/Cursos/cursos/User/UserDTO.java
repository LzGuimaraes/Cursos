package dev.Cursos.cursos.User;

import java.util.List;

import dev.Cursos.cursos.Curso.CursoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id_user;
    private String nome;
    private int idade;
    private String email;
    private String password;
    private List<CursoModel> cursos;

}
