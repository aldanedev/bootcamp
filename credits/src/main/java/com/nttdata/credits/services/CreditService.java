package com.nttdata.credits.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.credits.domain.CreditCart;
import com.nttdata.credits.repository.CreditRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository ;

    public Flux<CreditCart> getCredits() {
        return creditRepository.findAll();
    }

    public Mono<CreditCart> addCredit(CreditCart credit) {
        
        return creditRepository.save(credit);
    }

    public Mono<CreditCart> getCredit(String id ) {
        return creditRepository.findById(id);
    }
}
