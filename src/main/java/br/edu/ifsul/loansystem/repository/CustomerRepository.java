package br.edu.ifsul.loansystem.repository;

import br.edu.ifsul.loansystem.dao.DAO;
import br.edu.ifsul.loansystem.model.Customer;
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
                INSERT INTO customers (name, last_name, role, cpf, email, birthdate, score, paycheck)
                VALUES (?,?,?,?,?,?,?,?)
                """;
        return jdbcTemplate.update(
                sql,
                c.name(), c.lastName(), c.role().toString(), c.cpf(), c.email(), c.birthdate(), c.score(), c.paycheck());
    }

    @Override
    public Integer update(Customer c, Long id) {
        var sql = """
                UPDATE customers 
                SET name=?, last_name=?, role=?, cpf=?, email=?, birthdate=?, score=?, paycheck=?
                WHERE id = ?
                """;
        return jdbcTemplate.update(
                sql,
                c.name(), c.lastName(), c.role().toString(), c.cpf(), c.email(), c.birthdate(), c.score(), c.paycheck(), id);
    }

    @Override
    public Integer delete(Long id) {
        var sql = """
                DELETE FROM customers 
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Customer> findAll() {
        var sql = """
                SELECT *
                FROM customers
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }

    @Override
    public Optional<Customer> findById(Long id) {
        var sql = """
                SELECT *
                FROM customers
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new CustomerRowMapper(), id)
                .stream()
                .findFirst();
    }
}
