package dev.Cursos.cursos.Modulo.dto;

public record ModuloRequestDTO(
    String titulo,
    String descricao,
    Integer ordem,
    Long cursoId
) {}
