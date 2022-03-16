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
                rs.getLong("accounts.customer_id"),
                rs.getDouble("accounts.balance"),
                rs.getDouble("accounts.loan_tax"),
                rs.getDouble("accounts.loan_limit")
        );
        return new Customer(
                rs.getLong("customers.id"),
                rs.getString("customers.name"),
                rs.getString("customers.last_name"),
                Role.valueOf(rs.getString("customers.role")),
                rs.getString("customers.cpf"),
                rs.getString("customers.email"),
                rs.getDate("customers.birthdate").toLocalDate(),
                rs.getInt("customers.score"),
                rs.getDouble("customers.paycheck"),
                rs.getLong("customers.teller_id"),
                account.id() == 0 ? null : account
        );
    }
}
