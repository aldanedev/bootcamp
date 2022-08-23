package com.webflux.jfgb.webflux.repos;

import com.webflux.jfgb.webflux.domain.CuentaBancaria;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CuentaBancariaRepository extends ReactiveMongoRepository<CuentaBancaria, String> {
}