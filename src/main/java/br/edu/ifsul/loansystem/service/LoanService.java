package br.edu.ifsul.loansystem.service;


import br.edu.ifsul.loansystem.dao.DAO;
import br.edu.ifsul.loansystem.exception.NotFoundException;
import br.edu.ifsul.loansystem.model.Loan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final DAO<Loan> dao;

    public LoanService(DAO<Loan> dao) {
        this.dao = dao;
    }

    public void create(Loan loan) {
        // TODO: check if account exists
        Integer result = dao.create(loan);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public void update(Loan loan) {
        Integer result = dao.update(loan);
        if (result != 1) {
            throw new IllegalStateException("oops could not update loan");
        }
    }

    public void delete(Long id) {
        Optional<Loan> loans = dao.findById(id);
        loans.ifPresentOrElse(loan -> {
            Integer result = dao.delete(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete loan");
            }
        }, () -> {
            throw new NotFoundException(String.format("Loan with id %s not found", id));
        });
    }

    public List<Loan> findAll() {
        return dao.findAll();
    }

    public Loan findById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Loan with id %s not found", id)));
    }
}