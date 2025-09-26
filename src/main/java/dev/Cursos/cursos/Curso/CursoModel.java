package dev.Cursos.cursos.Curso;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ManyToMany;
import java.util.List;

import dev.Cursos.cursos.User.UserModel;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_curso")
public class CursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;
    private String nome;
    private String estado;
    private String descricao;

    @ManyToMany(mappedBy = "cursos")
    private List<UserModel> users;

}
