package dev.Cursos.cursos.Curso.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import dev.Cursos.cursos.Curso.StatusCurso;
import dev.Cursos.cursos.Post.PostModel;
import dev.Cursos.cursos.User.UserModel;


public record CursoResponseDTO(
    Long id_curso,
    String nome,
    StatusCurso status,
    String descricao,

    @JsonIgnoreProperties({"password", "cursos"})
    List<UserModel> users,

    @JsonIgnoreProperties({"curso"})
    List<PostModel> posts
) {}



