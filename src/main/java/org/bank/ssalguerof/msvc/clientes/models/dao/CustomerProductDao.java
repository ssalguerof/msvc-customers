package org.bank.ssalguerof.msvc.clientes.models.dao;

import org.bank.ssalguerof.msvc.clientes.models.documents.CustomerProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Interfaz que define métodos para consultar y manipular la información de CustomerProduct
 * en MongoDB de forma reactiva.
 * Esta interfaz extiende ReactiveMongoRepository, lo que permite realizar operaciones CRUD
 * y consultas personalizadas sobre la colección de CustomerProduct en la base de datos MongoDB.
 */
public interface CustomerProductDao extends ReactiveMongoRepository<CustomerProduct, String> {

}
