package br.edu.ifsul.loansystem.repository;

import br.edu.ifsul.loansystem.dao.DAO;
import br.edu.ifsul.loansystem.model.Customer;
import br.edu.ifsul.loansystem.model.Role;
import br.edu.ifsul.loansystem.util.CustomerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements DAO<Customer> {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer create(Customer c) {
        var sql = """
                INSERT INTO customers (name, last_name, role, cpf, email, birthdate, score, paycheck, teller_id)
                VALUES (?,?,?,?,?,?,?,?,?)
                """;
        return jdbcTemplate.update(
                sql,
                c.name(),
                c.lastName(),
                Role.CUSTOMER.toString(),
                c.cpf(),
                c.email(),
                c.birthdate(),
                c.score(),
                c.paycheck(),
                c.tellerId());
    }

    @Override
    public Integer update(Customer c) {
        var sql = """
                UPDATE customers\040
                SET name=?, last_name=?, role=?, cpf=?, email=?, birthdate=?, score=?, paycheck=?, teller_id=?
                WHERE id = ?
                """;
        return jdbcTemplate.update(
                sql,
                c.name(),
                c.lastName(),
                c.role().toString(),
                c.cpf(),
                c.email(),
                c.birthdate(),
                c.score(),
                c.paycheck(),
                c.tellerId(),
                c.id());
    }

    @Override
    public Integer delete(Long id) {
        var sql = """
                DELETE FROM customers\040
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Customer> findAll() {
        var sql = """
                SELECT *
                FROM customers\040
                LEFT JOIN accounts\040
                ON customers.id = accounts.customer_id
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new CustomerRowMapper(jdbcTemplate));
    }

    @Override
    public Optional<Customer> findById(Long id) {
        var sql = """
                SELECT *
                FROM customers\040
                LEFT JOIN accounts\040
                ON customers.id = accounts.customer_id
                WHERE customers.id = ?;
                """;
        return jdbcTemplate.query(sql, new CustomerRowMapper(jdbcTemplate), id)
                .stream()
                .findFirst();
    }
}
