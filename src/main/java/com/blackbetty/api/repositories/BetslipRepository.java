package com.blackbetty.api.repositories;

import com.blackbetty.api.entities.Betslip;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BetslipRepository extends JpaRepository<Betslip, Long> {

}
