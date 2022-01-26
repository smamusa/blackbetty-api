package com.blackbetty.api.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class CreateBetslipRequestModel {
    @Getter
    @Setter
    private Double amount;
    @Getter
    @Setter
    private List<MatchRequestModel> matches;

    CreateBetslipRequestModel() {
    }
}
