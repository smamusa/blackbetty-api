package com.blackbetty.api.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Offer")
@NoArgsConstructor
public class Offer {
    @Getter
    @Setter
    private @Id @GeneratedValue Long id;
    @Getter
    @Setter
    private String home;
    @Getter
    @Setter
    private String away;
    @Getter
    @Setter
    private Double hq;
    @Getter
    @Setter
    private Double aq;
    @Getter
    @Setter
    private Double tq;

    public Offer(String home, String away, Double hq, Double aq, Double tq) {
        this.home = home;
        this.away = away;
        this.hq = hq;
        this.aq = aq;
        this.tq = tq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Offer offer = (Offer) o;
        return Objects.equals(id, offer.id) &&
                Objects.equals(home, offer.home) &&
                Objects.equals(away, offer.away) &&
                Objects.equals(hq, offer.hq) &&
                Objects.equals(aq, offer.aq) &&
                Objects.equals(tq, offer.tq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, home, away, hq, aq, tq);
    }
}
