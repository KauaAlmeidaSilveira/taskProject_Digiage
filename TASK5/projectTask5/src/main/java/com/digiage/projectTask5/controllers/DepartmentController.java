package com.digiage.projectTask5.controllers;

import com.digiage.projectTask5.dto.DepartmentDTO;
import com.digiage.projectTask5.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> insert(@Valid @RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO result = departmentService.insertDepartment(departmentDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(uri).body(result);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<DepartmentDTO> update(@PathVariable Integer id, @RequestBody DepartmentDTO departmentDTO) {
        return ResponseEntity.ok(departmentService.update(id, departmentDTO));
    }


}
