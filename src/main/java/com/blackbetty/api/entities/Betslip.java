package com.blackbetty.api.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Betslip")
@EntityListeners(AuditingEntityListener.class)
public class Betslip {

    @Getter
    @Setter
    private @Id @GeneratedValue Long id;

    @Getter
    @Setter
    private double amount;

    @OneToMany
    @JoinColumn(name = "betslip_id")
    @Getter
    @Setter
    private List<Match> matches = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_date")
    @Getter
    @Setter
    private Date createdTime;

    public Betslip() {
    }

    public Betslip withAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Betslip withMatches(List<Match> matches) {
        this.matches = matches;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Betslip betslip = (Betslip) o;
        return Objects.equals(id, betslip.id) &&
                Objects.equals(amount, betslip.amount) &&
                Objects.equals(matches, betslip.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, matches);
    }

}
