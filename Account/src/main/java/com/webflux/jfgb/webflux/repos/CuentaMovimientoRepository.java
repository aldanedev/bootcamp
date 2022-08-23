package com.webflux.jfgb.webflux.repos;

import com.webflux.jfgb.webflux.domain.CuentaMovimiento;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaMovimientoRepository extends ReactiveMongoRepository<CuentaMovimiento,String> {
}