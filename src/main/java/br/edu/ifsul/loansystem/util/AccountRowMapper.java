package br.edu.ifsul.loansystem.util;

import br.edu.ifsul.loansystem.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Account(
                rs.getLong("id"),
                rs.getLong("customer_id"),
                rs.getDouble("balance")
        );
    }
}
