package br.edu.ifsul.loansystem.model;

public record Account(
        Long id,
        Long customerId,
        Double balance,
        Double loanTax,
        Double loanLimit) {
}
