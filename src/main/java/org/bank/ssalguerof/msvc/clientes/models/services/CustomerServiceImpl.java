package org.bank.ssalguerof.msvc.clientes.models.services;

import org.bank.ssalguerof.msvc.clientes.models.dao.CustomerDao;
import org.bank.ssalguerof.msvc.clientes.models.documents.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementación de {@link CustomerService} que interactúa con {@link CustomerDao}.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired
  CustomerDao clienteDao;

  
  @Override
  public Flux<Customer> findAll() {
    return clienteDao.findAll();
  }

  @Override
  public Mono<Customer> findById(String id) {
    return clienteDao.findById(id);
  }

  @Override
  public Mono<Customer> save(Customer cliente) {
    return clienteDao.save(cliente);
  }

  @Override
  public Mono<Void> delete(Customer cliente) {
    return clienteDao.delete(cliente);
  }

  @Override
  public Mono<Customer> findByNumDocumento(String numDocumento) {
    return clienteDao.findByNumDocumento(numDocumento);
  }
}
