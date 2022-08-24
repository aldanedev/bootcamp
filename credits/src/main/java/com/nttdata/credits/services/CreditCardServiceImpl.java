package com.nttdata.credits.services;

import java.net.URI;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.credits.domain.CreditCard;

import com.nttdata.credits.repository.CreditCardRepository;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditRepository;

    public Flux<CreditCard> list() {
        return creditRepository.findAll();
    }

    public Mono<CreditCard> register(CreditCard creditCard) {

        Function<Boolean, Mono<CreditCard>> exits = (Boolean b) -> {
            if (b) {
                return Mono.error(new Exception("Credit card already registered"));
            } else {
                return creditRepository.save(creditCard);
            }
        };

        return creditRepository.findByNumber(creditCard.getNumber())
                .hasElement()
                .flatMap(exits);

    }

    public Mono<CreditCard> findById(String id) {
        return creditRepository.findById(id);
    }

    public Mono<CreditCard> updater(String id, CreditCard creditCard) {
        return creditRepository.findById(id)
                .flatMap(existingCredit -> {
                    existingCredit.setDescription(creditCard.getDescription());
                    existingCredit.setLimitCredit(creditCard.getLimitCredit());
                    existingCredit.setNumber(creditCard.getNumber());
                    return creditRepository.save(existingCredit);
                });

    }

}
