package dev.Cursos.cursos.Modulo.dto;

public record ModuloResponseDTO(
    Long id_modulo,
    String titulo,
    String descricao,
    Integer ordem,
    Long cursoId
) {}
