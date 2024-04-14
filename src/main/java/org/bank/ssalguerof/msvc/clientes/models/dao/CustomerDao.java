package org.bank.ssalguerof.msvc.clientes.models.dao;

import org.bank.ssalguerof.msvc.clientes.models.documents.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerDao extends ReactiveMongoRepository<Customer, String> {
    Mono<Customer> findByNumDocumento(String numDocumento);
}
