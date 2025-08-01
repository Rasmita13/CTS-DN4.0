package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static List<Employee> employeeList = new ArrayList<>();

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(employee.getId())) {
                employeeList.set(i, employee);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}