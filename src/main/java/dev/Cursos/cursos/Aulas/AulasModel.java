package dev.Cursos.cursos.Aulas;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.Cursos.cursos.Modulo.ModuloModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_aula")
public class AulasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aula;
    private String titulo;
    private String descricao;
    private String recursos;
    private int ordem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modulo")
    @JsonIgnore
    private ModuloModel modulo;
    
}
