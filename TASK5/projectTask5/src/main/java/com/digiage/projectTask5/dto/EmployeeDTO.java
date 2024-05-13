package com.digiage.projectTask5.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Integer id;
    @Size(min = 3, max = 100, message = ("Nome deve ter entre 3 e 100 caracteres"))
    @NotBlank(message = "Nome requerido") // Garante que o campo não seja nulo ou vazio
    private String nome;
    @NotBlank(message = "Email requerido")
    private String email;
    private String telefone;
    @Past(message = "A data deve ser no passado")
    private LocalDate dataNascimento;
    private String cargo;
}
