package dev.Cursos.cursos.Post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDTO {
    Long id_post;
    String titulo;
    String descricao;
    Long cursoId;
}
