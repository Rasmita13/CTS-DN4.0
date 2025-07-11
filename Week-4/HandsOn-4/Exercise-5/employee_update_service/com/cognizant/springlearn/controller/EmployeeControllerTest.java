package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.model.Skill;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testUpdateEmployee_InvalidName_ShouldReturnBadRequest() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName(""); // Invalid name
        employee.setSalary(50000.0);
        employee.setPermanent(true);
        employee.setDateOfBirth(new java.util.Date());
        Department dept = new Department();
        dept.setId(1);
        dept.setName("HR");
        employee.setDepartment(dept);
        Skill skill = new Skill();
        skill.setId(1);
        skill.setName("Java");
        employee.setSkills(Collections.singletonList(skill));

        mockMvc.perform(put("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest());
    }
}