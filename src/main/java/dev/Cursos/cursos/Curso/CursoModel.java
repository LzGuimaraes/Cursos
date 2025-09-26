package dev.Cursos.cursos.Curso;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_curso")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CursoModel {
    private Long id_curso;
    private String nome;
    private String estado;
    private String descricao;
}
