package dev.Cursos.cursos.Modulo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.Cursos.cursos.Curso.CursoModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_modulo")
public class ModuloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_modulo;
    private String titulo;
    private String descricao;
    private Integer ordem;

    @OneToMany(mappedBy = "modulo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ModuloModel> modulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    @JsonIgnore
    private CursoModel curso;
}
