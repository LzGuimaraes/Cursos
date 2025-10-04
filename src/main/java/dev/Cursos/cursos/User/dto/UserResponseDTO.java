package dev.Cursos.cursos.User.dto;

import java.util.List;
import dev.Cursos.cursos.Curso.CursoModel;

public record UserResponseDTO(
    Long id_user,
    String nome,
    int idade,
    String email,
    List<CursoModel> cursos
) {}
