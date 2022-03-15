package br.edu.ifsul.loansystem.repository;

import br.edu.ifsul.loansystem.dao.DAO;
import br.edu.ifsul.loansystem.model.Customer;
import br.edu.ifsul.loansystem.model.Role;
import br.edu.ifsul.loansystem.model.Teller;
import br.edu.ifsul.loansystem.util.CustomerRowMapper;
import br.edu.ifsul.loansystem.util.TellerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TellerRepository implements DAO<Teller> {

    private final JdbcTemplate jdbcTemplate;

    public TellerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer create(Teller t) {
        var sql = """
                INSERT INTO tellers (name, last_name, role, cpf, email, birthdate, login, password)
                VALUES (?,?,?,?,?,?,?,?)
                """;
        return jdbcTemplate.update(
                sql,
                t.name(),
                t.lastName(),
                Role.TELLER.toString(),
                t.cpf(),
                t.email(),
                t.birthdate(),
                t.login(),
                t.password());
    }

    @Override
    public Integer update(Teller t) {
        var sql = """
                UPDATE tellers 
                SET name=?, last_name=?, role=?, cpf=?, email=?, birthdate=?, login=?, password=?
                WHERE id = ?
                """;
        return jdbcTemplate.update(
                sql,
                t.name(),
                t.lastName(),
                t.role().toString(),
                t.cpf(),
                t.email(),
                t.birthdate(),
                t.login(),
                t.password(),
                t.id());
    }

    @Override
    public Integer delete(Long id) {
        var sql = """
                DELETE FROM tellers 
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Teller> findAll() {
        var sql = """
                SELECT *
                FROM tellers
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new TellerRowMapper());
    }

    @Override
    public Optional<Teller> findById(Long id) {
        var sql = """
                SELECT *
                FROM tellers
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new TellerRowMapper(), id)
                .stream()
                .findFirst();
    }
}
