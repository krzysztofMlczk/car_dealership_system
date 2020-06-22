package pl.databazy.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginWindowJDBC {

    private Connection connection = null;

    public LoginWindowJDBC() {
        connection = ConnectToDatabase.connectAdmin();
    }

    public String loginUser(String login, String password) {
        try {
            String sql = "SELECT typ FROM uzytkownicy WHERE login = ? AND haslo = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, login);
            stmt.setString(2, password);

            ResultSet result = stmt.executeQuery();

            result.last();

            int size = result.getRow();

            if(size == 0) {
                return null;
            } else {
                return result.getString("typ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }
}