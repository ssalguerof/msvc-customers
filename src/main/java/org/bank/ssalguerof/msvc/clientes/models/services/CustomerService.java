package org.bank.ssalguerof.msvc.clientes.models.services;

import org.bank.ssalguerof.msvc.clientes.models.documents.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interface que define operaciones para la gestión de clientes del banco.
 */
public interface CustomerService {

  /**
   * Busca y devuelve todos los clientes.
   *
   * @return un Flux de Customer
   */
  public Flux<Customer> findAll();

  /**
   * Busca un cliente por su ID.
   *
   * @param id el ID del cliente a buscar
   * @return un Mono que contiene el cliente encontrado, o Mono.empty() si no se encuentra
   */
  public Mono<Customer> findById(String id);

  /**
   * Guarda o actualiza un cliente.
   *
   * @param cliente el cliente a guardar o actualizar
   * @return un Mono que contiene el cliente guardado o actualizado
   */
  public Mono<Customer> save(Customer cliente);

  /**
   * Elimina un cliente.
   *
   * @param cliente el cliente a eliminar
   * @return un Mono que indica la finalización exitosa de la operación de eliminación
   */
  public Mono<Void> delete(Customer cliente);

  /**
   * Busca un cliente por su número de documento.
   *
   * @param numDocumento el número de documento del cliente a buscar
   * @return un Mono que contiene el cliente encontrado, o Mono.empty() si no se encuentra
   */
  public Mono<Customer> findByNumDocumento(String numDocumento);

}
