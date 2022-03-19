package br.edu.ifsul.loansystem.controller;

import br.edu.ifsul.loansystem.model.Loan;
import br.edu.ifsul.loansystem.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/loan")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public void create(@RequestBody Loan loan) {
        loanService.create(loan);
    }

    @PutMapping
    public void update(@RequestBody Loan loan) {
        loanService.update(loan);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        loanService.delete(id);
    }

    @GetMapping
    public List<Loan> findAll() {
        return loanService.findAll();
    }

    @GetMapping("{id}")
    public Loan findById(@PathVariable("id") Long id) {
        return loanService.findById(id);
    }

}