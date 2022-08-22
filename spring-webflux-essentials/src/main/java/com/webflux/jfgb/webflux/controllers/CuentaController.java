package com.webflux.jfgb.webflux.controllers;

import com.webflux.jfgb.webflux.domain.Cuenta;
import com.webflux.jfgb.webflux.repos.CuentaRepository;
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
@RequestMapping("/account")
public class CuentaController {

    CuentaRepository cuentaRepository;

    @GetMapping(value = "/getAll")
    private Flux<Cuenta> getAll() {
        return getCuentaRepository().findAll();
    }

    @GetMapping(value = "/get/{id}")
    private Mono<Cuenta> getById(@PathVariable final String id) {
        return getCuentaRepository().findById(id);
    }

    @PostMapping(value = "/insert")
    private Mono<Cuenta> insert (@RequestBody final Cuenta cuenta){
        return save(cuenta);
    }

    @PutMapping(value = "/update")
    private Mono<Cuenta> update (@RequestBody final Cuenta cuenta){
        return save(cuenta);
    }

    @DeleteMapping(value = "/deleteAll")
    private Mono<Void> deleteAll(){
        return getCuentaRepository().deleteAll();
    }

    @DeleteMapping(value ="/deleteById")
    private Mono<Void> deleteById(@PathVariable final String id){
        return getCuentaRepository().deleteById(id);
    }

    private Mono<Cuenta> save(@RequestBody final Cuenta cuenta) {
        return getCuentaRepository().save(cuenta);
    }
}
