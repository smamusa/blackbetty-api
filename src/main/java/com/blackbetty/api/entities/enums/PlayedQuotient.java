package com.blackbetty.api.entities.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PlayedQuotient {

    HOME("HOME"),
    AWAY("AWAY"),
    TIED("TIED");

    private final String quotient;

    public String get() {
        return this.quotient;
    }

}
