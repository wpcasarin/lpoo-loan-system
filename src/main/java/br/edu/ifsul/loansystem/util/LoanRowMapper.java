package br.edu.ifsul.loansystem.util;

import br.edu.ifsul.loansystem.model.Loan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanRowMapper implements RowMapper<Loan> {

    @Override
    public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Loan(
                rs.getLong("loans.id"),
                rs.getDouble("loans.borrowed"),
                rs.getDouble("loans.to_receive"),
                rs.getDate("loans.borrowed_at").toLocalDate(),
                rs.getDate("loans.expires+at").toLocalDate(),
                rs.getLong("loans.account_id")
        );
    }
}
