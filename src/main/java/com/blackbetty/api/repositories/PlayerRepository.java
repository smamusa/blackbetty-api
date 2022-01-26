package com.blackbetty.api.repositories;

import com.blackbetty.api.entities.Player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
