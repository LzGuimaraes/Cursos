package dev.Cursos.cursos.Aulas.dto;

public record AulasResponseDTO(
    Long id_aula,
    String titulo,
    String descricao,
    String recurso,
    Long id_modulo
) {}
