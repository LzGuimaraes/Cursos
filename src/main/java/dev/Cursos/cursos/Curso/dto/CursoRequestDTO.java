package dev.Cursos.cursos.Curso.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CursoRequestDTO(
    Long id_curso,

    @NotBlank(message = "O nome do curso não pode estar em branco.")
    @Size(min = 3, max = 100, message = "O nome do curso deve ter entre 3 e 100 caracteres.")
    String nome,

    @NotBlank
    @Pattern(regexp = "ATIVO|INATIVO|EM_BREVE")
    String estado,

    @NotBlank(message = "A descrição não pode estar em branco.")
    @Size(min = 10, max = 500, message = "A descrição deve ter entre 10 e 500 caracteres.")
    String descricao
) {}