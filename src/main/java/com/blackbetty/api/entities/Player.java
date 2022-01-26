package com.blackbetty.api.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Player")
public class Player {
    @Getter
    @Setter
    private @Id Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    Double wallet;

    @OneToMany
    @JoinColumn(name = "betslip_id")
    @Getter
    @Setter
    private List<Betslip> betslips = new ArrayList<>();

    public Player() {

    }

    public Player withId(Long id) {
        this.id = id;
        return this;
    }

    public Player withName(String name) {
        this.name = name;
        return this;
    }

    public Player withWallet(Double wallet) {
        this.wallet = wallet;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Player player = (Player) o;
        return Objects.equals(id, player.id) &&
                Objects.equals(wallet, player.wallet) &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, wallet);
    }
}
