package dev.Cursos.cursos.Coment.dto;

public record CommentResponseDTO(
    Long id_comment,
    String descricao,
    Long postId
) {}
