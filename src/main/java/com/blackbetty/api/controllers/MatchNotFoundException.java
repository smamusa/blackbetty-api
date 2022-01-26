package com.blackbetty.api.controllers;

public class MatchNotFoundException extends RuntimeException {
    public MatchNotFoundException(Long id) {
        super("Could not find betslip or offer match " + id);
    }
}
