package br.edu.ifsul.loansystem.util;

import br.edu.ifsul.loansystem.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Account(
                rs.getLong("accounts.id"),
                rs.getLong("accounts.customer_id"),
                rs.getDouble("accounts.balance"),
                rs.getDouble("accounts.loan_tax"),
                rs.getDouble("accounts.loan_limit")
        );
    }
}
