package br.edu.ifsul.loansystem.util;

import br.edu.ifsul.loansystem.model.Customer;
import br.edu.ifsul.loansystem.model.Role;
import br.edu.ifsul.loansystem.model.Teller;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TellerRowMapper implements RowMapper<Teller> {

    private final JdbcTemplate jdbcTemplate;

    public TellerRowMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private List<Customer> findAllCustomers(Long id) {
        var sql = """
                SELECT *
                FROM customers
                LEFT JOIN accounts\040
                ON customers.id = accounts.customer_id
                WHERE customers.teller_id = ?;
                """;
        return this.jdbcTemplate.query(sql, new CustomerRowMapper(), id);
    }

    @Override
    public Teller mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<Customer> customers = findAllCustomers(rs.getLong("tellers.id"));
        return new Teller(
                rs.getLong("tellers.id"),
                rs.getString("tellers.name"),
                rs.getString("tellers.last_name"),
                Role.valueOf(rs.getString("tellers.role")),
                rs.getString("tellers.cpf"),
                rs.getString("tellers.email"),
                rs.getDate("tellers.birthdate").toLocalDate(),
                rs.getBoolean("tellers.is_admin"),
                rs.getString("tellers.login"),
                rs.getString("tellers.password"),
                customers
        );
    }
}
