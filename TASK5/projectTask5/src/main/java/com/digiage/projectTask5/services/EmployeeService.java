package com.digiage.projectTask5.services;

import com.digiage.projectTask5.domain.Employee;
import com.digiage.projectTask5.dto.EmployeeDTO;
import com.digiage.projectTask5.repositories.EmployeeRepository;
import com.digiage.projectTask5.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(String department, Pageable pageable) {
        Page<Employee> employeeList = employeeRepository.findByDepartmentName(department, pageable);
        return employeeList.map(EmployeeDTO::new);
    }

    @Transactional
    public EmployeeDTO insertEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        copyDtoToEntity(employeeDTO, employee);
        employee = employeeRepository.save(employee);
        return new EmployeeDTO(employee);
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado !!"));
        return new EmployeeDTO(employee);
    }

    @Transactional
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    public EmployeeDTO update(Integer id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado !!"));
        copyDtoToEntity(employeeDTO, employee);
        employee = employeeRepository.save(employee);
        return new EmployeeDTO(employee);
    }

    public void copyDtoToEntity(EmployeeDTO employeeDTO, Employee employee) {
        if (employeeDTO.getId() != null) {
            employee.setId(employeeDTO.getId());
        }
        if (employeeDTO.getNome() != null) {
            employee.setNome(employeeDTO.getNome());
        }
        if (employeeDTO.getEmail() != null) {
            employee.setEmail(employeeDTO.getEmail());
        }
        if (employeeDTO.getTelefone() != null) {
            employee.setTelefone(employeeDTO.getTelefone());
        }
        if (employeeDTO.getDataNascimento() != null) {
            employee.setDataNascimento(employeeDTO.getDataNascimento());
        }
        if (employeeDTO.getCargo() != null) {
            employee.setCargo(employeeDTO.getCargo());
        }
    }
}
