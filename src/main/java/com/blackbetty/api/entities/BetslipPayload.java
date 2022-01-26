package com.blackbetty.api.entities;

import java.util.List;

import lombok.Getter;

public class BetslipPayload {

    @Getter
    private Double amount;
    @Getter
    private List<Match> matches;

    public BetslipPayload() {

    }
}
