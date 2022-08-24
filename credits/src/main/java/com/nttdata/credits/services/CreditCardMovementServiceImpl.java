package com.nttdata.credits.services;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.credits.domain.CreditCard;
import com.nttdata.credits.domain.CreditCardMovement;
import com.nttdata.credits.repository.CreditCardMovementRepository;
import com.nttdata.credits.repository.CreditCardRepository;

import reactor.core.publisher.Mono;

@Service
public class CreditCardMovementServiceImpl implements CreditCardMovementService {
    @Autowired
    private CreditCardMovementRepository creditCardMovementRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    public Mono<CreditCardMovement> register(CreditCardMovement creditCardMovement) {

        Function<CreditCard, Mono<CreditCardMovement>> validate = (creditCard) -> {

            return creditCardMovementRepository.findCreditCardIdBy(creditCard.getId())
                    .reduce(creditCard.getLimitCredit() + creditCardMovement.getAmountSigned(),
                            CreditCardMovement::sumMovements)
                    .flatMap(amount -> {
                        if (amount < 0) {
                            return Mono.error(new Exception("Credit card movement exceeds limit"));
                        } else {
                            return creditCardMovementRepository.save(creditCardMovement);
                        }
                    });

        };

        return creditCardRepository.findById(creditCardMovement.getCreditCardId())
                .flatMap(validate)
                .switchIfEmpty(Mono.error(new Exception("Credit card not found")));

    }

}
