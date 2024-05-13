package com.digiage.projectTask5.dto;


import com.digiage.projectTask5.domain.Employee;

import java.time.LocalDate;

public class EmployeeDTO {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String cargo;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.nome = employee.getNome();
        this.email = employee.getEmail();
        this.telefone = employee.getTelefone();
        this.dataNascimento = employee.getDataNascimento();
        this.cargo = employee.getCargo();
    }

    public EmployeeDTO(Integer id, String nome, String email, String telefone, LocalDate dataNascimento, String cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cargo = cargo;
    }

    public EmployeeDTO() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
