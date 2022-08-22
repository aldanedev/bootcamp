package com.webflux.jfgb.webflux.repos;
import com.webflux.jfgb.webflux.domain.Cuenta;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends ReactiveMongoRepository<Cuenta, String> {
}