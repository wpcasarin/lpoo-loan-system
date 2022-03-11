package br.edu.ifsul.loansystem.util;

import br.edu.ifsul.loansystem.model.Account;
import br.edu.ifsul.loansystem.model.Customer;
import br.edu.ifsul.loansystem.model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {



    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account(
                rs.getLong("accounts.id"),
                rs.getLong("customers.id"),
                rs.getDouble("accounts.balance")
        );
        return new Customer(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("last_name"),
                Role.valueOf(rs.getString("role")),
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getDate("birthdate").toLocalDate(),
                rs.getInt("score"),
                rs.getDouble("paycheck"),
                account.id() == 0 ? null : account
        );
    }
}
