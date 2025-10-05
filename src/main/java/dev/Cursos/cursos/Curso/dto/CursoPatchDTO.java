package dev.Cursos.cursos.Curso.dto;

import jakarta.validation.constraints.Pattern;

public record CursoPatchDTO(
    @Pattern(regexp = "ATIVO|INATIVO|EM_BREVE", message = "O estado deve ser ATIVO, INATIVO ou EM_BREVE")
    String estado
) {}
