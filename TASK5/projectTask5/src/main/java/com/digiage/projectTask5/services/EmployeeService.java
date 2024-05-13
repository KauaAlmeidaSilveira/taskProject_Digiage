package com.digiage.projectTask5.services;

import com.digiage.projectTask5.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String teste(){
        return "Funcionou !!";
    }

}
