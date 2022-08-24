package com.nttdata.credits.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.credits.domain.LoanBank;
import com.nttdata.credits.repository.LoanBankRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanBankServiceImpl implements LoanBankService {

    @Autowired
    private LoanBankRepository loanBankRepository;

    public Flux<LoanBank> list() {
        return loanBankRepository.findAll();
    }

    public Mono<LoanBank> register(LoanBank loanBank) {

        return loanBankRepository.save(loanBank);
    }

    public Mono<LoanBank> findById(String id) {
        return loanBankRepository.findById(id);
    }

    public Mono<LoanBank> updater(String id, LoanBank loanBank) {
        return loanBankRepository.findById(id)
                .flatMap(existingLoanBank -> {
                    existingLoanBank.setDescription(loanBank.getDescription());
                    existingLoanBank.setAmount(loanBank.getAmount());
                    existingLoanBank.setDues(loanBank.getDues());
                    existingLoanBank.setCustomerId(loanBank.getCustomerId());
                    return loanBankRepository.save(existingLoanBank);
                });
    }

}
