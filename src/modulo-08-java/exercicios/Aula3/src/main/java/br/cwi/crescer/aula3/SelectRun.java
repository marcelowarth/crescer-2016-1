package br.cwi.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marcelo.moura
 */
public class SelectRun {

    public static void main(String[] args) {

        final String ddl = "CREATE TABLE PESSOA ("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";

        final String dml = "INSERT INTO PESSOA (ID_PESSOA,NM_PESSOA)"
                + " VALUES (1, 'MARCELO')";

        final String query = "Select * from Pessoa";

        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement()) {
            //statement.executeUpdate(ddl);
            //statement.executeUpdate(dml);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("NM_PESSOA"));
            }
            rs.close();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
