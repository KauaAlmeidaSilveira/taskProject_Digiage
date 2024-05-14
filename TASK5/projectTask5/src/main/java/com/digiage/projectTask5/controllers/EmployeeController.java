package com.digiage.projectTask5.controllers;

import com.digiage.projectTask5.dto.EmployeeDTO;
import com.digiage.projectTask5.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Metodo que retorna todos os funcionários de forma paginada
    // ele recebe um parametro de departamento para filtrar os funcionários
    // além disso, na url é possível passar parametros de paginação
    // Exemplo: http://localhost:8080/employee?department=TI&page=0&size=5
    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll(
            @RequestParam(name = "department", defaultValue = "") String department,
            Pageable pageable) {
        return ResponseEntity.ok(employeeService.findAll(department, pageable));
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert(@Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO result = employeeService.insertEmployee(employeeDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(uri).body(result);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.update(id, employeeDTO));
    }


}
