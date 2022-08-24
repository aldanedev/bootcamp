package com.nttdata.credits.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.credits.domain.CreditCardMovement;

import reactor.core.publisher.Flux;

@Repository
public interface CreditCardMovementRepository extends ReactiveMongoRepository<CreditCardMovement, String> {
    Flux<CreditCardMovement> findCreditCardIdBy(String id);
}
