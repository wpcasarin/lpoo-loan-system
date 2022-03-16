package br.edu.ifsul.loansystem.repository;

import br.edu.ifsul.loansystem.dao.DAO;
import br.edu.ifsul.loansystem.model.Loan;
import br.edu.ifsul.loansystem.util.LoanRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoanRepository implements DAO<Loan> {

    private final JdbcTemplate jdbcTemplate;

    public LoanRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer create(Loan l) {
        var sql = """
                INSERT INTO loans (borrowed, to_receive, borrowed_at, expires_at, account_id)
                VALUES (?,?,?,?,?);
                """;
        return jdbcTemplate.update(
                sql,
                l.borrowed(),
                l.toReceive(),
                l.borrowed(),
                l.expiresAt(),
                l.accountId());
    }

    @Override
    public Integer update(Loan l) {
        var sql = """
                UPDATE loans
                SET borrowed = ?, to_receive = ?, borrowed_at = ?, expires_at = ?
                WHERE id = ?
                """;
        return jdbcTemplate.update(
                sql,
                l.borrowed(),
                l.toReceive(),
                l.borrowed(),
                l.expiresAt(),
                l.id());
    }

    @Override
    public Integer delete(Long id) {
        var sql = """
                DELETE FROM loans
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Loan> findAll() {
        var sql = """
                SELECT *
                FROM loans
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new LoanRowMapper());
    }

    @Override
    public Optional<Loan> findById(Long id) {
        var sql = """
                SELECT *
                FROM loans
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new LoanRowMapper(), id)
                .stream()
                .findFirst();
    }
}
