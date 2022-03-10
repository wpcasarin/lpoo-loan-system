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
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("last_name"),
                Role.valueOf(rs.getString("role")),
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getDate("birthdate").toLocalDate(),
                rs.getBoolean("is_admin"),
                rs.getString("login"),
                rs.getString("password")
        );
    }
}
