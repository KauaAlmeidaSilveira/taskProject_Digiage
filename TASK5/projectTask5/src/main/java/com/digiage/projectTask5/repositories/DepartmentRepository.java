package com.digiage.projectTask5.repositories;

import com.digiage.projectTask5.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
