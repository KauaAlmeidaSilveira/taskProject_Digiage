package com.digiage.projectTask5.repositories;

import com.digiage.projectTask5.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(nativeQuery = true, value = """
                SELECT e.*
                            FROM tb_employee e\s
                            JOIN tb_department d ON e.department_id = d.id\s
                            WHERE UPPER(d.nome) LIKE UPPER(CONCAT('%', :departmentName, '%'))
                """
    )
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);
}
