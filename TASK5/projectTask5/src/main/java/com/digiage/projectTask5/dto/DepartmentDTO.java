package com.digiage.projectTask5.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DepartmentDTO {
    private Integer id;
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;
    private String descricao;
    private String status;
}
