package com.blackbetty.api.models;

import com.blackbetty.api.entities.enums.PlayedQuotient;

import lombok.Getter;
import lombok.Setter;

public class MatchRequestModel {
    @Getter
    @Setter
    private Long offerId;
    @Getter
    @Setter
    private PlayedQuotient playedQuotient;

    MatchRequestModel() {
    }
}
