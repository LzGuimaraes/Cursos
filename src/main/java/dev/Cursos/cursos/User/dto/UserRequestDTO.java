package dev.Cursos.cursos.User.dto;

public record UserRequestDTO(
    String nome,
    int idade,
    String email,
    String password
) {}
