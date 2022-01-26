package com.blackbetty.api.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.blackbetty.api.entities.enums.PlayedQuotient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Match")
public class Match {
    @Getter
    @Setter
    private @Id @GeneratedValue Long id;

    // The quote played for this match (hq, aq or tq)
    @Getter
    @Setter
    private PlayedQuotient playedQuotient;

    @OneToOne
    @JoinColumn(name = "offer_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Offer offer;

    public Match() {

    }

    public Match withOffer(Offer offer) {
        this.offer = offer;
        return this;
    }

    public Match withPlayedQuotient(PlayedQuotient quotient) {
        this.playedQuotient = quotient;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id) &&
                Objects.equals(playedQuotient, match.playedQuotient) &&
                Objects.equals(offer, match.offer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                playedQuotient, offer);
    }

}
