package com.digiage.projectTask5.repositories;

import com.digiage.projectTask5.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
