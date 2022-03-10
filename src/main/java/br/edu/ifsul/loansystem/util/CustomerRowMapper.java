package br.edu.ifsul.loansystem.util;

import br.edu.ifsul.loansystem.model.Customer;
import br.edu.ifsul.loansystem.model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
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
                rs.getLong("account_id")
        );
    }
}
