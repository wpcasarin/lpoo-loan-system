package br.edu.ifsul.loansystem.service;


import br.edu.ifsul.loansystem.dao.DAO;
import br.edu.ifsul.loansystem.exception.NotFoundException;
import br.edu.ifsul.loansystem.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final DAO<Customer> dao;

    public CustomerService(DAO<Customer> dao) {
        this.dao = dao;
    }

    public List<Customer> findAll() {
        return dao.findAll();
    }

    public void create(Customer customer) {
        // TODO: check if user exists
        int result = dao.create(customer);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public void delete(Long id) {
        Optional<Customer> customers = dao.findById(id);
        customers.ifPresentOrElse(customer -> {
            int result = dao.delete(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete user");
            }
        }, () -> {
            throw new NotFoundException(String.format("User with id %s not found", id));
        });
    }

    public Customer findById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User with id %s not found", id)));
    }
}