package pl.databazy.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import pl.databazy.data.Storage;

public class AdminWindowJDBC { 

    private Connection connection = null;

    public AdminWindowJDBC() {
        connection = ConnectToDatabase.connectAdmin();
    }

    public boolean makeBackup() {
        return false;
    }

    public boolean restoreDatabase() {
        return false;
    }

    public boolean znajdzWszystkichProducentow() {
            
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

    public boolean znajdzWszystkieRezerwacje() {
            
        try {
            String sql = "SELECT R.id_rezerwacji, K.imie, K.nazwisko, R.data_rezerwacji, M.marka, M.model, M.pojemnosc_silnika, "
            + "M.moc_silnika, O.rok_produkcji, O.kolor, O.nazwa_pakietu, O.cena_calkowita, R.ilosc_zamowionych_sztuk "+
            "FROM oferta AS O INNER JOIN rezerwacje AS R ON O.id_oferty = R.id_oferty INNER JOIN klienci AS K "+ 
            "ON R.id_klienta = K.id_klienta INNER JOIN modele AS M ON M.id_modelu = O.id_modelu;";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            Storage.getReservations(result);

            return true;

        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean znajdzKonkretnegoProducenta(String producer) {

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
    
    public boolean znajdzWszystkieModele() {
    	
    	try {
            String sql = "SELECT * FROM modele";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            Storage.getModels(result);

            return true;

        } catch(SQLException e) {
            return false;
        }
    }

    public boolean znajdzKonkretnaRezerwacje(String imieKlienta, String nazwiskoKlienta) {
        String sql = null;
        PreparedStatement statement = null;
    
    	try{
    		if(!imieKlienta.equals("") && !nazwiskoKlienta.equals("")) {
                sql = "SELECT R.id_rezerwacji, K.imie, K.nazwisko, R.data_rezerwacji, M.marka, M.model, M.pojemnosc_silnika, "+
                "M.moc_silnika, O.rok_produkcji, O.kolor, O.nazwa_pakietu, O.cena_calkowita, R.ilosc_zamowionych_sztuk "+
                "FROM oferta AS O INNER JOIN rezerwacje AS R ON O.id_oferty = R.id_oferty INNER JOIN klienci AS K "+
                "ON R.id_klienta = K.id_klienta INNER JOIN modele AS M ON M.id_modelu = O.id_modelu WHERE K.imie = ? AND K.nazwisko = ?";
    			statement = connection.prepareStatement(sql);
    			statement.setString(1, imieKlienta);
    			statement.setString(2, nazwiskoKlienta);
    			
    		}
    		else if(!imieKlienta.equals("") && nazwiskoKlienta.equals("")) {
    			sql = "SELECT R.id_rezerwacji, K.imie, K.nazwisko, R.data_rezerwacji, M.marka, M.model, M.pojemnosc_silnika, "+
                "M.moc_silnika, O.rok_produkcji, O.kolor, O.nazwa_pakietu, O.cena_calkowita, R.ilosc_zamowionych_sztuk "+
                "FROM oferta AS O INNER JOIN rezerwacje AS R ON O.id_oferty = R.id_oferty INNER JOIN klienci AS K "+
                "ON R.id_klienta = K.id_klienta INNER JOIN modele AS M ON M.id_modelu = O.id_modelu WHERE K.imie = ?";
    			statement = connection.prepareStatement(sql);
    			statement.setString(1, imieKlienta);
    		}
    		else if(imieKlienta.equals("") && !nazwiskoKlienta.equals("")) {
    			sql = "SELECT R.id_rezerwacji, K.imie, K.nazwisko, R.data_rezerwacji, M.marka, M.model, M.pojemnosc_silnika, "+
                "M.moc_silnika, O.rok_produkcji, O.kolor, O.nazwa_pakietu, O.cena_calkowita, R.ilosc_zamowionych_sztuk "+
                "FROM oferta AS O INNER JOIN rezerwacje AS R ON O.id_oferty = R.id_oferty INNER JOIN klienci AS K "+
                "ON R.id_klienta = K.id_klienta INNER JOIN modele AS M ON M.id_modelu = O.id_modelu WHERE K.nazwisko = ?";
    			statement = connection.prepareStatement(sql);
    			statement.setString(1, nazwiskoKlienta);
    		}
    		
    		ResultSet result = statement.executeQuery();

            Storage.getReservations(result);

            return true;
    	} catch(SQLException e) {
            return false;
        }
    }
    
    public boolean znajdzKonkretnyModel(String marka, String model) {
    	
    	String sql = null;
        PreparedStatement statement = null;
    	
    	try {
    		if(!marka.equals("") && !model.equals("")) {
    			sql = "SELECT * FROM modele WHERE marka = ? AND model = ?";
    			statement = connection.prepareStatement(sql);
    			statement.setString(1, marka);
    			statement.setString(2, model);
    			
    		}
    		else if(!marka.equals("") && model.equals("")) {
    			sql = "SELECT * FROM modele WHERE marka = ?";
    			statement = connection.prepareStatement(sql);
    			statement.setString(1, marka);
    		}
    		else if(marka.equals("") && !model.equals("")) {
    			sql = "SELECT * FROM modele WHERE model = ?";
    			statement = connection.prepareStatement(sql);
    			statement.setString(1, model);
    		}
    		
    		ResultSet result = statement.executeQuery();

            Storage.getModels(result);

            return true;
    	} catch(SQLException e) {
            return false;
        }
    }
    public boolean znajdzWszystkiePakiety() {
        try {
            String sql = "SELECT * FROM pakiety";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            Storage.getPackages(result);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean znajdzKonkretnyPakiet(String pakiet) {

        try {
            String sql = "SELECT * FROM pakiety WHERE nazwa_pakietu = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pakiet);

            ResultSet result = statement.executeQuery();

            Storage.getPackages(result);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean dodajPakiet(String nazwaPakietu, int cenaPakietu) {
        try {
            String sql = "INSERT INTO pakiety VALUES(?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nazwaPakietu);
            statement.setInt(2, cenaPakietu);
            
            statement.executeUpdate();
            return true;
            
        } catch(SQLException e) {
            return false;
        }
    }

    public boolean dodajProducenta(String nazwaProducenta) {
        try {
            String sql = "INSERT INTO dostepni_producenci VALUES(?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nazwaProducenta);
            
            statement.executeUpdate();
            return true;
            
        } catch(SQLException e) {
            return false;
        }
    }

    public boolean usunPakiet(String nazwaPakietu) {
        try {
            String sql = "DELETE FROM pakiety WHERE nazwa_pakietu = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nazwaPakietu);

            statement.executeUpdate();
            return true;
        } catch(SQLException e) {
            return false;
        }
    }

    public boolean usunProducenta(String nazwaProducenta) {
        try {
            String sql = "DELETE FROM dostepni_producenci WHERE marka = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nazwaProducenta);

            statement.executeUpdate();
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean znajdzWszystkieKolory() {
        try {
            String sql = "SELECT * FROM kolory";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            Storage.getColors(result);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean znajdzKonkretnyKolor(String nazwaKoloru) {
        try {
            String sql = "SELECT * FROM kolory WHERE nazwa_koloru = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nazwaKoloru);

            ResultSet result = statement.executeQuery();

            Storage.getColors(result);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean dodajKolor(String nazwaKoloru, int cenaKoloru) {
        try {
            String sql = "INSERT INTO kolory VALUES(?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nazwaKoloru);
            statement.setInt(2, cenaKoloru);
            
            statement.executeUpdate();
            return true;
            
        } catch(SQLException e) {
            return false;
        }
    }

    public boolean usunKolor(String nazwaKoloru) {
        try {
            String sql = "DELETE FROM kolory WHERE nazwa_koloru = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nazwaKoloru);

            statement.executeUpdate();
            return true;
        } catch(SQLException e) {
            return false;
        }
    }


    public boolean znajdzWszystkieOferty() {

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

    public boolean znajdzKonkretnaOferte(String producer, String model, String color) {

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

    public boolean dodajKlienta(String firstname, String lastname, String phoneNumber) {

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

    public boolean dodajModel(String marka, String model, double pojemnosc, int moc, int cenaBazowa) {

        try {
            String sql = "Insert INTO modele(marka, model, pojemnosc_silnika, moc_silnika, cena_bazowa) "
            +"VALUES(?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, marka);
            statement.setString(2, model);
            statement.setDouble(3, pojemnosc);
            statement.setInt(4, moc);
            statement.setInt(5, cenaBazowa);

            statement.executeUpdate();

            return true;

        }catch(SQLException e) {
            return false;
        }

    }

    public boolean usunKlienta(int id) {
        try {
            String sql = "DELETE FROM klienci WHERE id_klienta = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            return true;
        }catch(SQLException ex) {
            return false;
        }
    }

    public boolean usunModel(int id) {

        try {
            String sql = "DELETE FROM modele WHERE id_modelu = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            return true;
        }catch(SQLException ex) {
            return false;
        }
    }

    public boolean przeprowadzTransakcje(int carId, int clientId, int amount) {
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

    public boolean usunRezerwacje(int id) {
        try {
            String sql = "DELETE FROM rezerwacje WHERE id_rezerwacji = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            return true;
        } catch(SQLException e){
            return false;
        }
    }

    public boolean usunOferte(int id) {

        try {
            String sql = "DELETE FROM oferta WHERE id_oferty = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            return true;
        } catch(SQLException e){
            return false;
        }
    }

    public boolean znajdzWszystkichKlientow() {

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

    public boolean znajdzKonkretnegoKlienta(String imie, String nazwisko) {

        String sql = null;
        PreparedStatement statement = null;

        try {
            if(!imie.equals("")&&!nazwisko.equals("")) {
                sql = "SELECT id_klienta, imie, nazwisko, numer_telefonu "
                +"FROM klienci WHERE imie = ? AND nazwisko = ?";

                statement = connection.prepareStatement(sql);
                
                statement.setString(1, imie);
                statement.setString(2, nazwisko);

            }else if(!imie.equals("")&& nazwisko.equals("")) {

                sql = "SELECT id_klienta, imie, nazwisko, numer_telefonu "
                +"FROM klienci WHERE imie = ?";

                statement = connection.prepareStatement(sql);
                
                statement.setString(1, imie);

            }else if(imie.equals("") && !nazwisko.equals("")) {

                sql = "SELECT id_klienta, imie, nazwisko, numer_telefonu "
                +"FROM klienci WHERE nazwisko = ?";

                statement = connection.prepareStatement(sql);
            
                statement.setString(1, nazwisko);

            }   

            ResultSet result = statement.executeQuery();

            Storage.getClients(result);

            return true;

        }catch(SQLException ex) {
            return false;
        }

    }

    public boolean dodajOferte(int modelId, String kolor, String pakiet, Date date) {
        
        try {
        
        String sql = "INSERT INTO oferta(id_modelu, kolor, nazwa_pakietu, rok_produkcji, stan_magazynowy) VALUES(?, ?, ?, ?, 0)";     
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, modelId);
        statement.setString(2, kolor);
        statement.setString(3, pakiet);
        statement.setDate(4, date);

        statement.executeUpdate();

        return true;
        } catch(SQLException e) {
            return false;
        }

    }

    public boolean dodajDoMagazynu(int id, int ilosc) {

        try {
            
            String sql = "UPDATE oferta SET stan_magazynowy = stan_magazynowy + ? WHERE id_oferty = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, ilosc);
            statement.setInt(2, id);

            statement.executeUpdate();

            return true;
        } catch(SQLException e) {
            return false;
        }
    }
}