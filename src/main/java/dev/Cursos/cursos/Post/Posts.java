package dev.Cursos.cursos.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_posts")
public class Posts {
    private Long id_post;
    private String titulo;
    private String descricao;
    private String data_publicacao;
}
