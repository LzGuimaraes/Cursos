package dev.Cursos.cursos.Curso;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.Cursos.cursos.Post.PostsModel;
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
    
    @JsonIgnore
    @ManyToMany(mappedBy = "cursos")
    private List<UserModel> users;

    @JsonIgnore
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostsModel> posts;

}
