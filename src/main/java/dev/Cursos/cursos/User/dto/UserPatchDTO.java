package dev.Cursos.cursos.User.dto;

import java.util.List;

public record UserPatchDTO(
    String nome,
    Integer idade,
    String email,
    String password,
    List<Long> cursoIds
) {}
