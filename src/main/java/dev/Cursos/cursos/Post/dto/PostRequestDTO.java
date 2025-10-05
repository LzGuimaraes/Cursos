package dev.Cursos.cursos.Post.dto;

import jakarta.validation.constraints.NotBlank;

public record PostRequestDTO(
    @NotBlank String titulo,
    @NotBlank String descricao,
    Long cursoId
) {}

