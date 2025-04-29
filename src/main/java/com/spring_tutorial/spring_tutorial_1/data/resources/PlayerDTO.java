package com.spring_tutorial.spring_tutorial_1.data.resources;

public class PlayerDTO {

    private String name;
    private String surname;
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
