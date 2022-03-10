package br.edu.ifsul.loansystem.repository;

import br.edu.ifsul.loansystem.dao.DAO;
import br.edu.ifsul.loansystem.model.Account;
import br.edu.ifsul.loansystem.util.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepository implements DAO<Account> {

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer create(Account a) {
        var sql = """
                INSERT INTO accounts (customer_id, balance)
                VALUES (?,?);
                """;
        return jdbcTemplate.update(
                sql,
                a.customerId(), a.balance());
    }

    @Override
    public Integer update(Account a) {
        var sql = """
                UPDATE accounts
                SET balance = ?
                WHERE id = ?
                """;
        return jdbcTemplate.update(
                sql,
                a.balance(), a.id());
    }

    @Override
    public Integer delete(Long id) {
        var sql = """
                DELETE FROM accounts
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Account> findAll() {
        var sql = """
                SELECT *
                FROM accounts
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }

    @Override
    public Optional<Account> findById(Long id) {
        var sql = """
                SELECT *
                FROM accounts
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new AccountRowMapper(), id)
                .stream()
                .findFirst();
    }
}
