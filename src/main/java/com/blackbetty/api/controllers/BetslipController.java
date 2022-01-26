package com.blackbetty.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.blackbetty.api.entities.Betslip;
import com.blackbetty.api.entities.Match;
import com.blackbetty.api.entities.Player;
import com.blackbetty.api.models.CreateBetslipRequestModel;
import com.blackbetty.api.repositories.BetslipRepository;
import com.blackbetty.api.repositories.MatchRepository;
import com.blackbetty.api.repositories.OfferRepository;
import com.blackbetty.api.repositories.PlayerRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetslipController {
    private final BetslipRepository repository;
    private final OfferRepository offerRepository;
    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;

    BetslipController(BetslipRepository repository, OfferRepository offerRepository, MatchRepository matchRepository,
            PlayerRepository playerRepository) {
        this.repository = repository;
        this.offerRepository = offerRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping("/betslips")
    List<Betslip> all() {
        return repository.findAll();
    }

    @PostMapping(value = "/betslips")
    public Betslip testPost(@RequestBody CreateBetslipRequestModel payload) {
        Player defaultPlayer = playerRepository.findById((long) 1).get();

        // Reduce wallet for amount
        defaultPlayer.setWallet(defaultPlayer.getWallet() - payload.getAmount());

        List<Match> matches = matchRepository.saveAll(payload.getMatches().stream()
                .map(matchRequestModel -> new Match()
                        .withOffer(offerRepository.findById(matchRequestModel.getOfferId()).get())
                        .withPlayedQuotient(matchRequestModel.getPlayedQuotient()))
                .collect(Collectors.toList()));

        Betslip newBetslip = repository.save(new Betslip().withAmount(payload.getAmount())
                .withMatches(matches));

        defaultPlayer.getBetslips().add(newBetslip);
        playerRepository.save(defaultPlayer);

        return newBetslip;
    }

    // Single betslip
    @GetMapping("/betslips/{id}")
    Betslip one(@PathVariable Long id) {
        return repository.findById(id).get();
    }

}
