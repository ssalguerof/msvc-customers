package org.bank.ssalguerof.msvc.clientes.controllers;

import org.bank.ssalguerof.msvc.clientes.models.documents.Customer;
import org.bank.ssalguerof.msvc.clientes.models.services.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase controlador del servicio Rest para administrar la informacion de un cliente del banco.
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
  @Autowired
  CustomerService clienteService;

  @GetMapping
  public Flux<Customer> findAll() {
    return clienteService.findAll();
  }

  @GetMapping("/{id}")
  public Mono<Customer> findById(@PathVariable String id) {
    return clienteService.findById(id);
  }

  @PostMapping
  public Mono<Customer> saveCustomer(@RequestBody Customer customer) {
    return clienteService.save(customer);
  }

  /**
   * Endpoint encargado de actualizar la información de un cliente.
   * Actualiza la información del cliente especificado utilizando el ID proporcionado
   * en el objeto `customer`.
   */
  @PutMapping
  public Mono<Customer> updateCustomer(@RequestBody Customer customer) {
    return clienteService.findById(customer.getId())
      .flatMap(existingCustomer -> {
        BeanUtils.copyProperties(customer, existingCustomer, "id");
        return clienteService.save(existingCustomer);
      });
  }

  /**
   * Endpoint encargado de la actualización de un cliente por numero de documento.
   */
  @PutMapping("/{numDocumento}")
  public Mono<Customer> updateByNumDocumento(@PathVariable String numDocumento,
                                             @RequestBody Customer customer) {
    return clienteService.findByNumDocumento(numDocumento).flatMap(existingCustomer -> {
      BeanUtils.copyProperties(customer, existingCustomer, "id");
      return clienteService.save(existingCustomer);
    });
  }
}
