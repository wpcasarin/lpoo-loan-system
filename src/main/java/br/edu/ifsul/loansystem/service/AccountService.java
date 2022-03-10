package br.edu.ifsul.loansystem.service;


import br.edu.ifsul.loansystem.dao.DAO;
import br.edu.ifsul.loansystem.exception.NotFoundException;
import br.edu.ifsul.loansystem.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final DAO<Account> dao;

    public AccountService(DAO<Account> dao) {
        this.dao = dao;
    }

    public void create(Account account) {
        // TODO: check if account exists
        Integer result = dao.create(account);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public void update(Account account) {
        Integer result = dao.update(account);
        if (result != 1) {
            throw new IllegalStateException("oops could not update account");
        }
    }

    public void delete(Long id) {
        Optional<Account> accounts = dao.findById(id);
        accounts.ifPresentOrElse(account -> {
            Integer result = dao.delete(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete account");
            }
        }, () -> {
            throw new NotFoundException(String.format("Account with id %s not found", id));
        });
    }

    public List<Account> findAll() {
        return dao.findAll();
    }

    public Account findById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Account with id %s not found", id)));
    }
}