package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.projection.EmployeeNameSalaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<EmployeeNameSalaryProjection> findBy();

    @Query("SELECT new com.example.employeemanagement.dto.EmployeeDTO(e.name, e.salary) FROM Employee e")
    List<EmployeeDTO> findAllEmployeeDTOs();
}
