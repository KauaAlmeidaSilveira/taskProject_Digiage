package com.digiage.projectTask5.services;

import com.digiage.projectTask5.domain.Department;
import com.digiage.projectTask5.dto.DepartmentDTO;
import com.digiage.projectTask5.repositories.DepartmentRepository;
import com.digiage.projectTask5.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll() {
        return departmentRepository.findAll().stream().map(DepartmentDTO::new).toList();
    }

    @Transactional
    public DepartmentDTO insertDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        copyDtoToEntity(departmentDTO, department);
        department = departmentRepository.save(department);
        return new DepartmentDTO(department);
    }

    @Transactional(readOnly = true)
    public DepartmentDTO findById(Integer id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado !!"));
        return new DepartmentDTO(department);
    }

    @Transactional
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Transactional
    public DepartmentDTO update(Integer id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado !!"));
        copyDtoToEntity(departmentDTO, department);
        department = departmentRepository.save(department);
        return new DepartmentDTO(department);
    }

    public void copyDtoToEntity(DepartmentDTO departmentDTO, Department department) {
        if (departmentDTO.getId() != null) {
            department.setId(departmentDTO.getId());
        }
        if (departmentDTO.getNome() != null) {
            department.setNome(departmentDTO.getNome());
        }
        if (departmentDTO.getDescricao() != null) {
            department.setDescricao(departmentDTO.getDescricao());
        }
        if (departmentDTO.getStatus() != null) {
            department.setStatus(departmentDTO.getStatus());
        }
    }
}
