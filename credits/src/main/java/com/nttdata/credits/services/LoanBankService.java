package com.nttdata.credits.services;

import com.nttdata.credits.domain.LoanBank;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanBankService {
    Flux<LoanBank> list();

    Mono<LoanBank> register(LoanBank loanBank);

    Mono<LoanBank> findById(String id);

    Mono<LoanBank> updater(String id, LoanBank loanBank);
}
