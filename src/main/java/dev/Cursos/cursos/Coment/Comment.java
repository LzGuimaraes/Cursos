package dev.Cursos.cursos.Coment;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_comment")
public class Comment {
    private Long id_comment;
    private String texto;
    private String data_comment;
}
