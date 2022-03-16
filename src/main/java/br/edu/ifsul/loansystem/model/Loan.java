package br.edu.ifsul.loansystem.model;

import java.time.LocalDate;

public record Loan(
        Long id,
        Double borrowed,
        Double toReceive,
        LocalDate borrowedAt,
        LocalDate expiresAt,
        Long accountId) {
}