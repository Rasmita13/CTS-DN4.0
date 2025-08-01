package com.cognizant.springlearn.model;

import jakarta.validation.constraints.Size;

public class Country {

    @Size(min = 2, max = 2, message = "Country code should be 2 characters")
    private String code;

    private String name;

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}