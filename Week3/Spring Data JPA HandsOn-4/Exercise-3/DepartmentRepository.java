package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query methods
    Optional<Department> findByName(String name);

    boolean existsByName(String name);
}

