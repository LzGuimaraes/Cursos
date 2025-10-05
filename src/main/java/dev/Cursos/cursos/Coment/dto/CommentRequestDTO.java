package dev.Cursos.cursos.Coment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentRequestDTO(
    @NotBlank String descricao,
    @NotNull Long postId
) {}
