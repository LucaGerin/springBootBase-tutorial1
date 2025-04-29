package com.spring_tutorial.spring_tutorial_1.data.resources;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PlayerDTO {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @Positive
    private Integer yearBirth;

    public PlayerDTO(String name, String surname, Integer yearBirth) {
        this.name = name;
        this.surname = surname;
        this.yearBirth = yearBirth;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Integer getYearBirth() {
        return yearBirth;
    }
    public void setYearBirth(Integer yearBirth) {
        this.yearBirth = yearBirth;
    }

}
