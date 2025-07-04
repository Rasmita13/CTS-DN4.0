package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query methods
    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByFirstNameContainingIgnoreCase(String keyword);

    List<Employee> findBySalaryGreaterThan(Double amount);
}

