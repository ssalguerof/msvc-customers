package org.bank.ssalguerof.msvc.clientes.models.dao;

import org.bank.ssalguerof.msvc.clientes.models.documents.CustomerProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerProductDao extends ReactiveMongoRepository<CustomerProduct, String> {

}
