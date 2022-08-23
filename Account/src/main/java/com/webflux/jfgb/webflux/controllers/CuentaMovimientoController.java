package com.webflux.jfgb.webflux.controllers;

import com.webflux.jfgb.webflux.domain.CuentaMovimiento;
import com.webflux.jfgb.webflux.repos.CuentaMovimientoRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@RestController
@RequestMapping("/accountMovement")
public class CuentaMovimientoController {
    CuentaMovimientoRepository cuentaBancariaRepository;

    @GetMapping(value = "/getAll")
    private Flux<CuentaMovimiento> getAll() {
        return getCuentaBancariaRepository().findAll();
    }

    @GetMapping(value = "/get/{id}")
    private Mono<CuentaMovimiento> getById(@PathVariable final String id) {
        return getCuentaBancariaRepository().findById(id);
    }

    @PostMapping(value = "/insert")
    private Mono<CuentaMovimiento> insert (@RequestBody final CuentaMovimiento cuenta){
        return save(cuenta);
    }

    @PutMapping(value = "/update")
    private Mono<CuentaMovimiento> update (@RequestBody final CuentaMovimiento cuenta){
        return save(cuenta);
    }

    @DeleteMapping(value = "/deleteAll")
    private Mono<Void> deleteAll(){
        return getCuentaBancariaRepository().deleteAll();
    }

    @DeleteMapping(value ="/deleteById")
    private Mono<Void> deleteById(@PathVariable final String id){
        return getCuentaBancariaRepository().deleteById(id);
    }
    private Mono<CuentaMovimiento> save(@RequestBody final CuentaMovimiento cuenta) {
        return getCuentaBancariaRepository().save(cuenta);
    }
}
