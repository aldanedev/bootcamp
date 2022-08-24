package com.nttdata.credits.services;

import com.nttdata.credits.domain.CreditCard;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {
    Flux<CreditCard> list();

    Mono<CreditCard> register(CreditCard creditCard);

    Mono<CreditCard> findById(String id);

    Mono<CreditCard> updater(String id, CreditCard creditCard);
}
