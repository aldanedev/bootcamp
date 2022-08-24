package com.nttdata.credits.services;

import com.nttdata.credits.domain.CreditCardMovement;

import reactor.core.publisher.Mono;

public interface CreditCardMovementService {
        Mono<CreditCardMovement> register(CreditCardMovement creditCardMovement);
}
