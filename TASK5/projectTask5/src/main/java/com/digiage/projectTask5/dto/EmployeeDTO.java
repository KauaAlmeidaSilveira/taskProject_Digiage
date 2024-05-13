package com.digiage.projectTask5.dto;

import com.digiage.projectTask5.domain.Employee;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;
    @NotBlank
    @Email(message = "O email deve ser válido, ex: example@gmail.com")
    private String email;
    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "O telefone deve seguir o formato (xx)xxxxx-xxxx")
    private String telefone;
    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data de nascimento deve ser anterior a data atual")
    private LocalDate dataNascimento;
    @NotBlank(message = "O cargo é obrigatório")
    private String cargo;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.nome = employee.getNome();
        this.email = employee.getEmail();
        this.telefone = employee.getTelefone();
        this.dataNascimento = employee.getDataNascimento();
        this.cargo = employee.getCargo();
    }
}
