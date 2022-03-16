package br.edu.ifsul.loansystem.util;

import br.edu.ifsul.loansystem.model.Account;
import br.edu.ifsul.loansystem.model.Loan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountRowMapper implements RowMapper<Account> {

    private final JdbcTemplate jdbcTemplate;

    public AccountRowMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private List<Loan> findAllLoans(Long id) {
        var sql = """
                SELECT *
                FROM loans
                JOIN accounts\040
                ON loans.account_id = accounts.id
                WHERE loans.account_id = ?;
                """;
        return this.jdbcTemplate.query(sql, new LoanRowMapper(), id);
    }

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<Loan> loans = findAllLoans(rs.getLong("accounts.id"));
        return new Account(
                rs.getLong("accounts.id"),
                rs.getLong("accounts.customer_id"),
                rs.getDouble("accounts.balance"),
                rs.getDouble("accounts.loan_tax"),
                rs.getDouble("accounts.loan_limit"),
                loans
        );
    }
}
