package br.edu.ifsul.loansystem.controller;

import br.edu.ifsul.loansystem.model.Teller;
import br.edu.ifsul.loansystem.service.TellerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tellers")
public class TellerController {

    private final TellerService tellerService;

    public TellerController(TellerService tellerService) {
        this.tellerService = tellerService;
    }

    @PostMapping
    public void create(@RequestBody Teller teller) {
        tellerService.create(teller);
    }

    @PutMapping
    public void update(@RequestBody Teller teller) {
        tellerService.update(teller);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        tellerService.delete(id);
    }

    @GetMapping
    public List<Teller> findAll() {
        return tellerService.findAll();
    }

    @GetMapping("{id}")
    public Teller findById(@PathVariable("id") Long id) {
        return tellerService.findById(id);
    }
}