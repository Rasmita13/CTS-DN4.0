package com.cognizant.springlearn.model;

import jakarta.validation.constraints.*;

public class Department {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 30)
    private String name;

    // Getters and setters
}