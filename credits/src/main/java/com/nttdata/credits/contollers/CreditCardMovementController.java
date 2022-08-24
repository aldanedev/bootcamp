package com.nttdata.credits.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.credits.domain.CreditCardMovement;
import com.nttdata.credits.services.CreditCardMovementService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/creditCardMovements")

public class CreditCardMovementController {
    @Autowired
    private CreditCardMovementService creditCardMovementService;

    @PostMapping
    public Mono<ResponseEntity<CreditCardMovement>> addMovement(@RequestBody CreditCardMovement creditCardMovement) {

        return creditCardMovementService.register(creditCardMovement)
                .map(c -> ResponseEntity.status(HttpStatus.CREATED).body(c));
    }
}
