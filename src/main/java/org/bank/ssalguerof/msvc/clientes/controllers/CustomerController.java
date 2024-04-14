package org.bank.ssalguerof.msvc.clientes.controllers;

import org.bank.ssalguerof.msvc.clientes.models.documents.Customer;
import org.bank.ssalguerof.msvc.clientes.models.services.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService clienteService;

    @GetMapping
    public Flux<Customer> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable String id){return clienteService.findbyId(id);}

    @PostMapping
    public Mono<Customer> saveCustomer(@RequestBody Customer customer){
        return  clienteService.save(customer);
    }
    @PutMapping
    public Mono<Customer> updateCustomer(@RequestBody Customer customer){
        return clienteService.findbyId(customer.getId())
                .flatMap(existingCustomer->{
                    BeanUtils.copyProperties(customer, existingCustomer, "id");
                    return  clienteService.save(existingCustomer);
                });
    }

    @PutMapping("/{numDocumento}")
    public Mono<Customer> updateByNumDocumento(@PathVariable String numDocumento, @RequestBody Customer customer) {
        return clienteService.findByNumDocumento(numDocumento).flatMap(existingCustomer->{
            BeanUtils.copyProperties(customer, existingCustomer, "id");
            return  clienteService.save(existingCustomer);
        });
    }
}
