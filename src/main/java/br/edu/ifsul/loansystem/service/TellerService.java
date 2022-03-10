package br.edu.ifsul.loansystem.service;


import br.edu.ifsul.loansystem.dao.DAO;
import br.edu.ifsul.loansystem.exception.NotFoundException;
import br.edu.ifsul.loansystem.model.Teller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TellerService {

    private final DAO<Teller> dao;

    public TellerService(DAO<Teller> dao) {
        this.dao = dao;
    }

    public void create(Teller teller) {
        // TODO: check if user exists
        Integer result = dao.create(teller);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public void update(Teller teller) {
        Integer result = dao.update(teller);
        if (result != 1) {
            throw new IllegalStateException("oops could not update user");
        }
    }

    public void delete(Long id) {
        Optional<Teller> tellers = dao.findById(id);
        tellers.ifPresentOrElse(teller -> {
            Integer result = dao.delete(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete user");
            }
        }, () -> {
            throw new NotFoundException(String.format("User with id %s not found", id));
        });
    }

    public List<Teller> findAll() {
        return dao.findAll();
    }

    public Teller findById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User with id %s not found", id)));
    }
}