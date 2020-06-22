package pl.databazy.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Storage {

    public static ArrayList<Car> cars;
    public static ArrayList<Model> models;
    public static ArrayList<Producer> producers;
    public static ArrayList<Client> clients;
    public static ArrayList<Package> packages;
    public static ArrayList<Color> colors;
    public static ArrayList<Reservation> reservations;

    public static void startStorage() {
        cars = new ArrayList<>();
        producers = new ArrayList<>();
        clients = new ArrayList<>();
        models = new ArrayList<>();
        colors = new ArrayList<>();
        packages = new ArrayList<>();
        reservations = new ArrayList<>();
    }


   public static void getCars(ResultSet result) throws SQLException {

        cars.clear();

        while(result.next()) {
            Storage.cars.add(new Car(result.getInt("id_oferty"), result.getInt("id_modelu"), result.getString("marka"), result.getString("model"),
            result.getFloat("pojemnosc_silnika"), result.getInt("moc_silnika"),
            result.getString("kolor"), result.getString("nazwa_pakietu"), result.getDate("rok_produkcji"), 
            result.getInt("cena_calkowita"), result.getInt("stan_magazynowy")));
        }
    }
   
   public static void getModels(ResultSet result) throws SQLException {
	   models.clear();

       while(result.next()) {
           Storage.models.add(new Model(result.getInt("id_modelu"), result.getString("marka"), result.getString("model"),
           result.getFloat("pojemnosc_silnika"), result.getInt("moc_silnika"), result.getInt("cena_bazowa")));
       }
   }

    public static void getProducers(ResultSet result) throws SQLException {

        producers.clear();

        while(result.next()) {
            producers.add(new Producer(result.getString("marka")));
        }
    }

    public static void getClients(ResultSet result) throws SQLException {
        clients.clear();

        while(result.next()) {
            clients.add(new Client(result.getInt("id_klienta"), result.getString("imie"), result.getString("nazwisko"),
            result.getString("numer_telefonu")));
        }
    }

    public static void getReservations(ResultSet result) throws SQLException {
        reservations.clear();

        while(result.next()) {
            reservations.add(new Reservation(result.getInt("R.id_rezerwacji"), result.getString("K.imie"), result.getString("K.nazwisko"), 
            result.getDate("R.data_rezerwacji"), result.getString("M.marka"), result.getString("M.model"), result.getDouble("M.pojemnosc_silnika"), 
            result.getInt("M.moc_silnika"), result.getDate("O.rok_produkcji"), result.getString("O.kolor"), result.getString("O.nazwa_pakietu"), 
            result.getInt("O.cena_calkowita"), result.getInt("R.ilosc_zamowionych_sztuk")));
        }
    }

    public static void getPackages(ResultSet result) throws SQLException {
        packages.clear();

       while(result.next()) {
           packages.add(new Package(result.getString("nazwa_pakietu"), result.getInt("cena_pakietu")));
       }
    }

    public static void getColors(ResultSet result) throws SQLException {
        colors.clear();

       while(result.next()) {
           colors.add(new Color(result.getString("nazwa_koloru"), result.getInt("cena_koloru")));
       }
    }
}