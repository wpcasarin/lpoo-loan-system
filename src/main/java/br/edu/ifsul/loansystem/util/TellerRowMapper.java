package br.edu.ifsul.loansystem.util;

import br.edu.ifsul.loansystem.model.Role;
import br.edu.ifsul.loansystem.model.Teller;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TellerRowMapper implements RowMapper<Teller> {

    @Override
    public Teller mapRow(ResultSet rs, int rowNum) throws SQLException {
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
                rs.getString("tellers.password")
        );
    }
}
