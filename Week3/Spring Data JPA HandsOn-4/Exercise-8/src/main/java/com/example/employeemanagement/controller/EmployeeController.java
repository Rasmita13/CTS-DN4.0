package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.projection.EmployeeNameSalaryProjection;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/projections/interface")
    public List<EmployeeNameSalaryProjection> getInterfaceProjections() {
        return employeeRepository.findBy();
    }

    @GetMapping("/projections/class")
    public List<EmployeeDTO> getClassProjections() {
        return employeeRepository.findAllEmployeeDTOs();
    }
}
