package pl.databazy.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import pl.databazy.data.Storage;

public class AdviserWindowJDBC { 

    private Connection connection = null;

    public AdviserWindowJDBC() {
        connection = ConnectToDatabase.connectSprzedawca();
    }

    public boolean getAllProducers() {
            
        try {
            String sql = "SELECT * FROM dostepni_producenci";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            Storage.getProducers(result);

            return true;

        } catch(SQLException e) {
            return false;
        }
    }

    public boolean getConcreteProducer(String producer) {

        try {
            String sql = "SELECT * FROM dostepni_producenci WHERE marka = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, producer);

            ResultSet result = statement.executeQuery();
            Storage.getProducers(result);

            return true;

        } catch(SQLException e) {
            System.out.println(e.getErrorCode());
            return false;
        }
    }

    public boolean getAllCars() {

        try {
            String sql = "SELECT o.id_oferty, m.id_modelu, m.marka, m.model, m.pojemnosc_silnika, m.moc_silnika, o.kolor, " 
            +"o.nazwa_pakietu, o.rok_produkcji, o.cena_calkowita, o.stan_magazynowy "
            +"FROM oferta AS o JOIN modele AS m ON o.id_modelu = m.id_modelu";
            PreparedStatement statement = connection.prepareStatement(sql);


            ResultSet result = statement.executeQuery();

            Storage.getCars(result);

            return true;

        } catch(SQLException e) {
            return false;
        }
    }

    public boolean getConcreteCar(String producer, String model, String color) {

        String sql = null;
        PreparedStatement statement = null;

        try {
            if(!producer.equals("") && !model.equals("") && !color.equals("")) {
                
                sql = "SELECT o.id_oferty, m.id_modelu, m.marka, m.model, m.pojemnosc_silnika, m.moc_silnika, o.kolor, " 
                +"o.nazwa_pakietu, o.rok_produkcji, o.cena_calkowita, o.stan_magazynowy "
                +"FROM oferta AS o JOIN modele AS m ON o.id_modelu = m.id_modelu "
                +"WHERE m.marka = ? AND m.model = ? AND o.kolor = ?";

                statement = connection.prepareStatement(sql);

                statement.setString(1, producer);
                statement.setString(2, model);
                statement.setString(3, color);
                
            }else if(!producer.equals("") && !model.equals("") && color.equals("")) {

                sql = "SELECT o.id_oferty, m.id_modelu, m.marka, m.model, m.pojemnosc_silnika, m.moc_silnika, o.kolor, " 
                +"o.nazwa_pakietu, o.rok_produkcji, o.cena_calkowita, o.stan_magazynowy "
                +"FROM oferta AS o JOIN modele AS m ON o.id_modelu = m.id_modelu "
                +"WHERE m.marka = ? AND m.model = ?";

                statement = connection.prepareStatement(sql);

                statement.setString(1, producer);
                statement.setString(2, model);
                
            }else if(!producer.equals("") && !color.equals("") && model.equals("")) {
                
                sql = "SELECT o.id_oferty, m.id_modelu, m.marka, m.model, m.pojemnosc_silnika, m.moc_silnika, o.kolor, " 
                +"o.nazwa_pakietu, o.rok_produkcji, o.cena_calkowita, o.stan_magazynowy "
                +"FROM oferta AS o JOIN modele AS m ON o.id_modelu = m.id_modelu "
                +"WHERE m.marka = ? AND o.kolor = ?";

                statement = connection.prepareStatement(sql);

                statement.setString(1, producer);
                statement.setString(2, color);
                
            }else if(producer.equals("") && !model.equals("") && !color.equals("")) {
                
                sql = "SELECT o.id_oferty, m.id_modelu, m.marka, m.model, m.pojemnosc_silnika, m.moc_silnika, o.kolor, " 
                +"o.nazwa_pakietu, o.rok_produkcji, o.cena_calkowita, o.stan_magazynowy "
                +"FROM oferta AS o JOIN modele AS m ON o.id_modelu = m.id_modelu "
                +"WHERE m.model = ? AND o.kolor = ?";

                statement = connection.prepareStatement(sql);

                statement.setString(1, model);
                statement.setString(2, color);
                
            }else if(!producer.equals("") && model.equals("") && color.equals("")) {
                
                sql = "SELECT o.id_oferty, m.id_modelu, m.marka, m.model, m.pojemnosc_silnika, m.moc_silnika, o.kolor, " 
                +"o.nazwa_pakietu, o.rok_produkcji, o.cena_calkowita, o.stan_magazynowy "
                +"FROM oferta AS o JOIN modele AS m ON o.id_modelu = m.id_modelu "
                +"WHERE m.marka = ?";

                statement = connection.prepareStatement(sql);

                statement.setString(1, producer);

            }else if(producer.equals("") && !model.equals("") && color.equals("")) {
                
                sql = "SELECT o.id_oferty, m.id_modelu, m.marka, m.model, m.pojemnosc_silnika, m.moc_silnika, o.kolor, " 
                +"o.nazwa_pakietu, o.rok_produkcji, o.cena_calkowita, o.stan_magazynowy "
                +"FROM oferta AS o JOIN modele AS m ON o.id_modelu = m.id_modelu "
                +"WHERE m.model = ?";

                statement = connection.prepareStatement(sql);

                statement.setString(1, model);
                
            }else if(producer.equals("") && model.equals("") && !color.equals("")) {
                
                sql = "SELECT o.id_oferty, m.id_modelu, m.marka, m.model, m.pojemnosc_silnika, m.moc_silnika, o.kolor, " 
                +"o.nazwa_pakietu, o.rok_produkcji, o.cena_calkowita, o.stan_magazynowy "
                +"FROM oferta AS o JOIN modele AS m ON o.id_modelu = m.id_modelu "
                +"WHERE o.kolor = ?";

                statement = connection.prepareStatement(sql);

                statement.setString(1, color);
                
            }


            ResultSet result = statement.executeQuery();

            Storage.getCars(result);

            return true;

        } catch(SQLException e) {
            return false;
        }
    }

    public boolean addClient(String firstname, String lastname, String phoneNumber) {

        try {
            String sql = "INSERT INTO klienci(imie, nazwisko, numer_telefonu) VALUES(?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, phoneNumber);

            statement.executeUpdate();

            return true;

        }catch(SQLException e) {
            System.out.println(e.getErrorCode());
            return false;
        }
    }

    public boolean makeTransaction(int carId, int clientId, int amount) {
            try {
                String sql = "{call rezerwacja_modelu(? ,?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(sql);

                statement.registerOutParameter(1, Types.INTEGER);
                statement.setInt(2, carId);
                statement.setInt(3, clientId);
                statement.setInt(4, amount);

                ResultSet tr = statement.executeQuery();

                int result = statement.getInt(1);

                statement.close();

                if(result == 1)
                    return true;
                else
                    return false;
            } catch(SQLException e) {
                System.out.println(e.getErrorCode());
                System.out.println(e.getMessage());
                return false;
            }
    }

    public boolean getClient() {

        try{
            String sql = "SELECT * FROM klienci";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            Storage.getClients(result);

            return true;
        }catch(SQLException e) {

            System.out.println(e.getErrorCode());
            return false;
        }
    }
}
