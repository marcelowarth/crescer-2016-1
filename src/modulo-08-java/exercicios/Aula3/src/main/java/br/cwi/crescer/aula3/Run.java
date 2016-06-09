package br.cwi.crescer.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Run {
    
    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());
    
    public static void main(String[] args) {
        String INSERT = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";
        try (final Connection connection = ConnectionUtils.getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, "Marcelo");
            preparedStatement.executeQuery();
        } catch (final SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }
}
