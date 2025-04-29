package com.spring_tutorial.spring_tutorial_1.controllers;

import com.spring_tutorial.spring_tutorial_1.data.resources.PlayerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayersController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PlayerDTO findPlayers(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "surname") String surname,
            @RequestParam(value = "yearBirth") Integer year
    ) {
        return new PlayerDTO(name, surname, year);
    }

}
