package org.bank.ssalguerof.msvc.clientes.models.dao;

import org.bank.ssalguerof.msvc.clientes.models.documents.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductDao extends ReactiveMongoRepository<Product, String> {

}
