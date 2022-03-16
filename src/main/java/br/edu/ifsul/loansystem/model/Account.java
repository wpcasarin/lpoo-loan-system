package br.edu.ifsul.loansystem.model;

import java.util.List;

public record Account(
        Long id,
        Long customerId,
        Double balance,
        Double loanTax,
        Double loanLimit,
        List<Loan> loans) {
}
