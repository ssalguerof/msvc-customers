package org.bank.ssalguerof.msvc.clientes.models.services;

import org.bank.ssalguerof.msvc.clientes.models.documents.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    public Flux<Customer> findAll();
    public Mono<Customer> findbyId(String id);
    public Mono<Customer> save(Customer cliente);
    public Mono<Void> delete(Customer cliente);
    public Mono<Customer> findByNumDocumento(String numDocumento);

}
