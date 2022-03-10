package br.edu.ifsul.loansystem.model;

import java.time.LocalDate;

public record Teller(
        Long id,
        String name,
        String lastName,
        Role role,
        String cpf,
        String email,
        LocalDate birthdate,
        String login,
        String password) {
}