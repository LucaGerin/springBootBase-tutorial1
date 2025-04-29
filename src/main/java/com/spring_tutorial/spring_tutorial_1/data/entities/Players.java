package com.spring_tutorial.spring_tutorial_1.data.entities;


import jakarta.persistence.*;

@Entity //Entita: classe che mappa a una tabella del database sottostante
@Table(name = "PLAYERS") //Notazione per mapping con la tabella del database, se l'annotazione @Table dovesse essere omessa, l’associazione tabella-entità verrà fatta utilizzando il nome della classe entità.
public class Players {

    @Id //la chiave primaria dell’entità
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Strategia di auogenerazione dell'Id
    @Column(name = "ID") //Per mappare l'attributo nell’entità su una colonna della tabella
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "YEAR_BIRTH")
    private Integer yearBirth;

    public Players() {
    }

    public Players(String name, String surname, Integer yearBirth) {
        this.name = name;
        this.surname = surname;
        this.yearBirth = yearBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
