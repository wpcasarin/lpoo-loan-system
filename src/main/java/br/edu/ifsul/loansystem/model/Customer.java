package br.edu.ifsul.loansystem.model;

import java.time.LocalDate;

public record Customer(
        Long id,
        String name,
        String lastName,
        Role role,
        String cpf,
        String email,
        LocalDate birthdate,
        Integer score,
        Double paycheck) {

}
