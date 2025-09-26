package dev.Cursos.cursos.User;

import dev.Cursos.cursos.Curso.CursoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String nome;
    private int idade;
    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany
    @JoinColumn(name = "id_curso")
    private CursoModel curso;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private Long posts;
}
