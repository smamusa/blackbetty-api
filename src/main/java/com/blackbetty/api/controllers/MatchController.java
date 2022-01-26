package com.blackbetty.api.controllers;

import java.util.List;

import com.blackbetty.api.entities.Match;
import com.blackbetty.api.repositories.MatchRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {
    private final MatchRepository repository;

    MatchController(MatchRepository repository) {
        this.repository = repository;
    }

    // All matches on a betslip
    @GetMapping("/matches")
    List<Match> all() {
        return repository.findAll();
    }

    // Single played match
    @GetMapping("/matches/{playedMatchId}")
    Match one(@PathVariable Long playedMatchId) {

        return repository.findById(playedMatchId)
                .orElseThrow(() -> new MatchNotFoundException(playedMatchId));
    }
}
