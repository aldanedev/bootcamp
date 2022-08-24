package com.nttdata.credits.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.credits.domain.LoanBank;

@Repository
public interface LoanBankRepository extends ReactiveMongoRepository<LoanBank, String> {

}
