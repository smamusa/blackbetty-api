package com.blackbetty.api;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.blackbetty.api.entities.Betslip;
import com.blackbetty.api.entities.Match;
import com.blackbetty.api.entities.Offer;
import com.blackbetty.api.entities.Player;
import com.blackbetty.api.entities.enums.PlayedQuotient;
import com.blackbetty.api.repositories.BetslipRepository;
import com.blackbetty.api.repositories.MatchRepository;
import com.blackbetty.api.repositories.OfferRepository;
import com.blackbetty.api.repositories.PlayerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class InitialDatabase implements WebMvcConfigurer {
        private static final Logger log = LoggerFactory.getLogger(InitialDatabase.class);

        @Override
        public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST");
        }

        @Bean
        CommandLineRunner initPlayerDatabase(PlayerRepository pRep, OfferRepository oRep, BetslipRepository bRep,
                        MatchRepository mRep) {

                // Default match offer
                List<Offer> offers = Arrays.asList(
                                new Offer("Spain", "Netherlands", 2.1, 1.3, 4.0),
                                new Offer("Brazil", "Germany", 2.1, 1.3, 9.0),
                                new Offer("Croatia", "France", 3.2, 1.3, 4.0),
                                new Offer("Germany", "Belgium", 1.3, 3.2, 7.4),
                                new Offer("Norway", "Slovenia", 1.3, 3.2, 7.4));
                // Default betslip
                Betslip defaultBetslip = new Betslip().withAmount(56);

                // Default player
                Player defaultPlayer = new Player().withId((long) 1).withName("Default Player")
                                .withWallet((double) 3000 - defaultBetslip.getAmount());

                Random rand = new Random();
                List<Match> playedMatches = offers.stream()
                                .map(offer -> (new Match().withOffer(offer)
                                                .withPlayedQuotient(PlayedQuotient.values()[rand
                                                                .nextInt(PlayedQuotient.values().length)])))
                                .collect(Collectors.toList());

                defaultBetslip.setMatches(playedMatches);
                defaultPlayer.getBetslips().add(defaultBetslip);

                return args -> {
                        offers.forEach(offer -> log.info("Preloading " + oRep.save(offer)));
                        playedMatches.forEach(match -> log.info("Preloading " + mRep.save(match)));
                        log.info("Preloading " + bRep.save(defaultBetslip));
                        log.info("Preloading " + pRep.save(defaultPlayer));
                };
        }

}
