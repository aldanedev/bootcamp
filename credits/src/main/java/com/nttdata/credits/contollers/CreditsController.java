package com.nttdata.credits.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.credits.domain.CreditCart;
import com.nttdata.credits.services.CreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/credits")
class CreditsController {
    @Autowired
    private CreditService creditService;

    @GetMapping
    public Flux<CreditCart> getCredits() {
        return creditService.getCredits();
    }

    @PostMapping
    public Mono<CreditCart> addCredit(@RequestBody CreditCart credit) {        
        return creditService.addCredit(credit);
        
    }

    @GetMapping("/{id}")
    public Mono<CreditCart> getCredit( @PathVariable String id) {
        return creditService.getCredit(id);
    }
}