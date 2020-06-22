package pl.databazy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {
    
    private static final String USERNAME_ADMIN = "admin";
    private static final String USERNAME_DEALER = "dealer";
    private static final String USERNAME_SPRZEDAWCA = "sprzedawca";

    private static final String PASSWORD_ADMIN = "admin";
    private static final String PASSWORD_DEALER = "dealer";
    private static final String PASSWORD_SPRZEDAWCA = "sprzedawca";

    private static final String DATABASE = "jdbc:mysql://localhost:3306/salon?serverTimezone=GMT";

    private static String driverName = "com.mysql.cj.jdbc.Driver";
    		//"com.mysql.cj.jdbc.Driver"; 

    private static Connection connection;

    public static Connection connectAdmin() {
        //try {
            //Class.forName(driverName);
            try {
                connection = DriverManager.getConnection(DATABASE, USERNAME_ADMIN, PASSWORD_ADMIN);
            }catch(SQLException ex) {
                System.out.println("Nie udalo sie polaczyc jako admin");
            }
       // }catch(ClassNotFoundException ex) {
        //    System.out.println("Nie znaleziono sterownika");
        //}
        return connection;
    }

    public static Connection connectDealer() {
        try {
            Class.forName(driverName);
            try {
                connection = DriverManager.getConnection(DATABASE, USERNAME_DEALER, PASSWORD_DEALER);
            }catch(SQLException ex) {
                System.out.println("Nie udalo sie polaczyc jako dealer");
            }
        }catch(ClassNotFoundException ex) {
            System.out.println("Nie znaleziono sterownika");
        }
        return connection;
    }

    public static Connection connectSprzedawca() {
        try {
            Class.forName(driverName);
            try {
                connection = DriverManager.getConnection(DATABASE, USERNAME_SPRZEDAWCA, PASSWORD_SPRZEDAWCA);
            }catch(SQLException ex) {
                System.out.println("Nie udalo sie polaczyc jako sprzedawca");
                ex.printStackTrace();
            }
        }catch(ClassNotFoundException ex) {
            System.out.println("Nie znaleziono sterownika");
        }
        return connection;
    }
}