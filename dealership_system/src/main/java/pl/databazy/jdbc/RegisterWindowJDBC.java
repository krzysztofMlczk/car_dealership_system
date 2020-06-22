package pl.databazy.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterWindowJDBC { 

    private Connection connection = null;

    public RegisterWindowJDBC() {
        connection = ConnectToDatabase.connectAdmin();
    }

    public boolean createUser(String login, String password, String type) {
        try {
            String sql = "INSERT INTO uzytkownicy VALUES(?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, login);
            stmt.setString(2, password);
            stmt.setString(3, type);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        }


    }
}