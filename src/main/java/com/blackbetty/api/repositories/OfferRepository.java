package com.blackbetty.api.repositories;

import com.blackbetty.api.entities.Offer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {

}
