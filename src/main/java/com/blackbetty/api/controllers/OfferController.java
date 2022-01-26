package com.blackbetty.api.controllers;

import java.util.List;

import com.blackbetty.api.entities.Offer;
import com.blackbetty.api.repositories.OfferRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

    private final OfferRepository repository;

    OfferController(OfferRepository repository) {
        this.repository = repository;
    }

    // Get all offered matches
    @GetMapping("/offer")
    List<Offer> all() {
        return repository.findAll();
    }

    // Get single offered match
    @GetMapping("/offer/{id}")
    Offer one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MatchNotFoundException(id));
    }
}
