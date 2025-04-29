package com.spring_tutorial.spring_tutorial_1.repositories;

import com.spring_tutorial.spring_tutorial_1.data.entities.Players;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
un repository Spring Data è una classe che fornisce tutta una serie di funzionalità pre-configurate e pre-sviluppate
che facilitano notevolmente l’accesso ai dati.
 */
@Repository
public interface PlayersRepository extends CrudRepository<Players, Long> { //La classe PlayerRepository è vuota perchè estende CrudRepository, la quale fornirà tutte le funzionalità necessarie per effettuare operazioni CRUD. L’unica cosa da fare è assegnare i Generics della classe CrudRepository.
    List<Players> findByName(String name);
}
