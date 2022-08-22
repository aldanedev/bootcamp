package com.nttdata.credits.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.credits.domain.CreditCart;

@Repository
public interface CreditRepository  extends ReactiveMongoRepository<CreditCart, String> {
    
}
