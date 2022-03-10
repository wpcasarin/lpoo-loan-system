package br.edu.ifsul.loansystem.controller;

import br.edu.ifsul.loansystem.model.Account;
import br.edu.ifsul.loansystem.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public void create(@RequestBody Account account) {
        accountService.create(account);
    }

    @PutMapping
    public void update(@RequestBody Account account) {
        accountService.update(account);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        accountService.delete(id);
    }

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("{id}")
    public Account findById(@PathVariable("id") Long id) {
        return accountService.findById(id);
    }

}