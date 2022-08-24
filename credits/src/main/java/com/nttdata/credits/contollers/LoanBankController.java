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

import com.nttdata.credits.domain.LoanBank;
import com.nttdata.credits.services.LoanBankService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/loanBanks")
public class LoanBankController {

    @Autowired
    private LoanBankService loanBankService;

    @GetMapping
    public ResponseEntity<Flux<LoanBank>> getLoanBanks() {
        return ResponseEntity.ok(loanBankService.list());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<LoanBank>> getLoanBank(@PathVariable String id) {
        return loanBankService.findById(id)
                .map(loanBank -> ResponseEntity.ok(loanBank))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<LoanBank>> addLoanBank(@RequestBody LoanBank loanBank) {
        return loanBankService.register(loanBank)
                .map(c -> ResponseEntity.status(HttpStatus.CREATED).body(c));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<LoanBank>> updateLoanBank(@PathVariable String id, @RequestBody LoanBank loanBank) {
        return loanBankService.updater(id, loanBank)
                .map(mapper -> ResponseEntity.ok(mapper))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
