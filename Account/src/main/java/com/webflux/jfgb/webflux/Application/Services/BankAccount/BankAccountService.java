package com.webflux.jfgb.webflux.Application.Services.BankAccount;

import com.webflux.jfgb.webflux.Domain.BankAccount;
import com.webflux.jfgb.webflux.Infrastructure.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.function.Function;
@Service
public class BankAccountService implements IBankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public Flux<BankAccount> list() {
        return bankAccountRepository.findAll();
    }

    public Mono<BankAccount> register(BankAccount bankAccount) {
        Function<Boolean, Mono<BankAccount>> exits = (Boolean b) -> {
            if (b) {
                return Mono.error(new Exception("Account bank already registered"));
            } else {
                return bankAccountRepository.save(bankAccount);
            }
        };

        return bankAccountRepository.findByNumber(bankAccount.getNumber())
                .hasElement()
                .flatMap(exits);

    }

    public Mono<BankAccount> findById(String id) {
        return bankAccountRepository.findById(id);
    }

    public Mono<BankAccount> updater(String id, BankAccount bankAccount) {
        return bankAccountRepository.findById(id)
                .flatMap(existingCredit -> {
                    existingCredit.setDescription(bankAccount.getDescription());
                    existingCredit.setLimitAccount(bankAccount.getLimitAccount());
                    existingCredit.setNumber(bankAccount.getNumber());
                    return bankAccountRepository.save(existingCredit);
                });
    }
}
