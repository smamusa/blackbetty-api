package com.blackbetty.api.controllers;

import java.util.List;

import com.blackbetty.api.entities.Player;
import com.blackbetty.api.repositories.PlayerRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    private final PlayerRepository repository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    // Get all players
    @GetMapping("/hello")
    String hello() {
        return "Hello";
    }

    // Get all players
    @GetMapping("/players")
    List<Player> all() {
        return repository.findAll();
    }

    // Single player
    @GetMapping("/players/{id}")
    Player one(@PathVariable Long id) {
        return repository.findById(id).get();
    }
}
