package dev.Cursos.cursos.User.dto;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record UserRequestDTO(
    @NotBlank(message = "O nome não pode estar em branco.")
    String nome,
    @Min(value = 1, message = "A idade deve ser maior que zero.")
    int idade,
    @NotBlank(message = "O email não pode estar em branco.")
    @Email(message = "O formato do email é inválido.")
    String email,
    @NotBlank(message = "A senha não pode estar em branco.")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    String password,
    List<Long> cursoIds
) {}
