package com.nttdata.credits.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.credits.domain.CreditCard;

import reactor.core.publisher.Mono;

@Repository
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, String> {
   Mono<CreditCard> findByNumber(String number);
}
