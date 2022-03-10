package br.edu.ifsul.loansystem.controller;

import br.edu.ifsul.loansystem.model.Customer;
import br.edu.ifsul.loansystem.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void create(@RequestBody Customer customer) {
        customerService.create(customer);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Customer customer, @PathVariable("id") Long id) {
        customerService.update(customer, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        customerService.delete(id);
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("{id}")
    public Customer findById(@PathVariable("id") Long id) {
        return customerService.findById(id);
    }

}