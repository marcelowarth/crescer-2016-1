package br.cwi.crescer.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class PessoaDAU implements IPessoa {

    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());

    @Override
    public void insert(Pessoa pessoa) {
        String INSERT = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        String UPDATE = "UPDATE PESSOA SET NM_PESSOA = ? WHERE ID_PESSOA = ?";
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setLong(2, pessoa.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        String DELETE = "DELETE FROM PESSOA WHERE ID_PESSOA = ?";
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setLong(1, pessoa.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public List<Pessoa> listAll() {
        String TODOS = "SELECT * FROM PESSOA";
        List lista = new LinkedList();
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(TODOS);
            while (rs.next()) {
                long i = rs.getLong("ID_PESSOA");
                String str = rs.getString("NM_PESSOA");
                Pessoa user = new Pessoa(i, str);
                lista.add(user);
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
        return lista;
    }

    @Override
    public List<Pessoa> findNome(String nome) {
        String PORNOME = "SELECT * FROM PESSOA WHERE NM_PESSOA LIKE ?";
        List lista = new LinkedList();
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(PORNOME)) {
            preparedStatement.setString(1, "%" + nome + "%");
            try (final ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    long i = rs.getLong("ID_PESSOA");
                    String str = rs.getString("NM_PESSOA");
                    Pessoa user = new Pessoa(i, str);
                    lista.add(user);
                }
            } catch (SQLException e) {
                LOGGER.severe(e.getMessage());
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
        return lista;
    }

}
