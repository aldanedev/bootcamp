package com.nttdata.credits.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.credits.domain.CreditCard;
import com.nttdata.credits.services.CreditCardService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/creditCards")
class CreditCardController {

    @Autowired
    private CreditCardService creditService;

    @GetMapping
    public ResponseEntity<Flux<CreditCard>> getCreditCards() {

        return ResponseEntity.ok(creditService.list());
    }

    @PostMapping
    public Mono<ResponseEntity<CreditCard>> addCredit(@RequestBody CreditCard creditCard) {

        return creditService.register(creditCard)
                .map(c -> ResponseEntity.status(HttpStatus.CREATED).body(c));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CreditCard>> getCreditCard(@PathVariable String id) {
        return creditService.findById(id)
                .map(creditCard -> ResponseEntity.ok(creditCard))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CreditCard>> updateCreditCard(@PathVariable String id,
            @RequestBody CreditCard creditCard) {
        return creditService.updater(id, creditCard)
                .map(mapper -> ResponseEntity.ok(mapper))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}