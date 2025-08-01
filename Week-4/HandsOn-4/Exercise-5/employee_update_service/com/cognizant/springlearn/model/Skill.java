package com.cognizant.springlearn.model;

import jakarta.validation.constraints.*;

public class Skill {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 30)
    private String name;

    // Getters and setters
}