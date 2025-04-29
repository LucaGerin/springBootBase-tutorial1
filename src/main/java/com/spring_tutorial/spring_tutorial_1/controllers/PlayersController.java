package com.spring_tutorial.spring_tutorial_1.controllers;

import com.spring_tutorial.spring_tutorial_1.data.entities.Players;
import com.spring_tutorial.spring_tutorial_1.data.resources.PlayerDTO;
import com.spring_tutorial.spring_tutorial_1.repositories.PlayersRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/* In Spring Boot una classe controller, che si crea tramite l'annotazione @RestController,
può definire una o più rotte tramite le quali sarà possibile accedere alle risorse.
Le principali funzioni sono:
- Reindirizzamento a metodi che implementano la logica di business
- Validazione dell'input
- Gestione degli errori
*/
@RestController
@RequestMapping("/players") //@RequestMapping che viene utilizzata per definire la radice delle rotte che verranno definite all'interno della classe
@Validated //Per abilitare la validazione
public class PlayersController {

    //Aggancia le rotte al repository
    @Autowired //Inniettare il repository nella classe PlayerController.
    private PlayersRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDTO> findPlayers(
            @RequestParam(value = "name")
            String name
    ) {
        List<Players> entities = repository.findByName(name);
        return entities
                .stream()
                .map(e -> new PlayerDTO(e.getName(), e.getSurname(), e.getYearBirth()))
                .collect(Collectors.toList());
    }


    @PostMapping
    public PlayerDTO createPlayer(@Valid //per abilitare la verifica dei vincoli specificati
                                      @RequestBody
                                        PlayerDTO request) {
        Players entity = new Players(request.getName(), request.getSurname(), request.getYearBirth());
        Players savedEntity = repository.save(entity);
        return new PlayerDTO(savedEntity.getName(), savedEntity.getSurname(), savedEntity.getYearBirth());
    }

}
