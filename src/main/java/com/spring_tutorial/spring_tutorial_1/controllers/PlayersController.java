package com.spring_tutorial.spring_tutorial_1.controllers;

import com.spring_tutorial.spring_tutorial_1.data.resources.PlayerDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PlayerDTO findPlayer(
            @RequestParam(value = "name")
            String name,

            @RequestParam(value = "surname")
            String surname,

            @Positive(message ="L'anno deve essere positivo!") //Applicare il vincolo
            @RequestParam(value = "yearBirth")
            Integer year
    ) {
        return new PlayerDTO(name, surname, year);
    }


    @PostMapping
    public PlayerDTO createPlayer(@Valid //per abilitare la verifica dei vincoli specificati
                                      @RequestBody
                                        PlayerDTO request) {
        return new PlayerDTO(request.getName(), request.getSurname(), request.getYearBirth());
    }

}
