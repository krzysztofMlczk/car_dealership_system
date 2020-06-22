package pl.databazy;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pl.databazy.data.Car;
import pl.databazy.data.Client;
import pl.databazy.data.Color;
import pl.databazy.data.Model;
import pl.databazy.data.Producer;
import pl.databazy.data.Reservation;
import pl.databazy.data.Package;
import pl.databazy.data.Storage;
import pl.databazy.jdbc.AdminWindowJDBC;

public class AdminWindowController {

    AdminWindowJDBC jdbc;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane generalTabPane;

    @FXML
    private Tab producenciTabPane;

    @FXML
    private AnchorPane producenciAnchorPane;

    @FXML
    private ListView<Producer> producenciListView;

    @FXML
    private Label producenciListViewLabel;

    @FXML
    private TextField producenciMarkaTextField;

    @FXML
    private Button producenciWszystkieMarkiButton;

    @FXML
    private Button producenciSzukajMarkiButton;

    @FXML
    private Label producenciWyszukajProducentaLabel;

    @FXML
    private Separator producenciLewySeparator;

    @FXML
    private Separator producenciPrawySeparator;

    @FXML
    private Button producenciNowyProducentButton;

    @FXML
    private Label producenciDodajProducentaLabel;

    @FXML
    private TextField producenciNazwaProducentaTextField;

    @FXML
    private Button producenciDodajProducentaButton;

    @FXML
    private Button producenciUsunButton;

    @FXML
    private Tab modeleTabPane;

    @FXML
    private AnchorPane modeleAnchorPane;

    @FXML
    private ListView<Model> modeleListView;

    @FXML
    private Label modeleListViewLabel;

    @FXML
    private TextField modeleMarkaTextField;

    @FXML
    private Button modeleWszystkieModeleButton;

    @FXML
    private Button modeleSzukajModeluButton;

    @FXML
    private Label modeleWyszukajModelLabel;

    @FXML
    private Separator modeleLewySeparator;

    @FXML
    private Separator modelePrawySeparator;

    @FXML
    private Button modeleNowyModelButton;

    @FXML
    private Label modeleDodajModelLabel;

    @FXML
    private Button modeleDodajModelButton;

    @FXML
    private Button modeleUsunButton;

    @FXML
    private TextField modeleModelTextField;

    @FXML
    private TextField modeleNazwaModeluTextField;

    @FXML
    private TextField modelePojemnoscSilnikaTextField;

    @FXML
    private TextField modeleMocSilnikaTextField;

    @FXML
    private TextField modeleCenaBazowaTextField;

    @FXML
    private ComboBox<Producer> modeleMarkaComboBox;

    @FXML
    private Tab pakietyTabPane;

    @FXML
    private Label klienciDodajBlad;

    @FXML
    private AnchorPane pakietyAnchorPane;

    @FXML
    private ListView<Package> pakietyListView;

    @FXML
    private Label pakietyListViewLabel;

    @FXML
    private TextField pakietyPakietTextField;

    @FXML
    private Button pakietyWszystkiePakietyButton;

    @FXML
    private Button pakietySzukajPakietuButton;

    @FXML
    private Label pakietyWyszukajPakietLabel;

    @FXML
    private Separator pakietyLewySeparator;

    @FXML
    private Separator pakietyPrawySeparator;

    @FXML
    private Button pakietyNowyPakietButton;

    @FXML
    private Label pakietyDodajPakietLabel;

    @FXML
    private TextField pakietyNazwaPakietuTextField;

    @FXML
    private Button pakietyDodajPakietButton;

    @FXML
    private Button pakietyUsunButton;

    @FXML
    private TextField pakietyCenaPakietuTextField;

    @FXML
    private Tab koloryTabPane;

    @FXML
    private AnchorPane koloryAnchorPane;

    @FXML
    private ListView<Color> koloryListView;

    @FXML
    private Label koloryListViewLabel;

    @FXML
    private TextField koloryKolorTextField;

    @FXML
    private Button koloryWszystkieKoloryButton;

    @FXML
    private Button kolorySzukajKoloruButton;

    @FXML
    private Label koloryWyszukajKolorLabel;

    @FXML
    private Separator koloryLewySeparator;

    @FXML
    private Separator koloryPrawySeparator;

    @FXML
    private Button koloryNowyKolorButton;

    @FXML
    private Label koloryDodajKolorLabel;

    @FXML
    private TextField koloryNazwaKoloruTextField;

    @FXML
    private Button koloryDodajKolorButton;

    @FXML
    private Button koloryUsunButton;

    @FXML
    private TextField koloryCenaKoloruTextField;

    @FXML
    private Tab klienciTabPane;

    @FXML
    private AnchorPane klienciAnchorPane;

    @FXML
    private ListView<Client> klienciListView;

    @FXML
    private Label klienciListViewLabel;

    @FXML
    private TextField klienciImieTextField;

    @FXML
    private Button klienciWszyscyKlienciButton;

    @FXML
    private Button klienciSzukajKlientaButton;

    @FXML
    private Label klienciWyszukajKlientaLabel;

    @FXML
    private Separator klienciLewySeparator;

    @FXML
    private Separator klienciPrawySeparator;

    @FXML
    private Button klienciNowyKlientButton;

    @FXML
    private Label klienciDodajKlientaLabel;

    @FXML
    private TextField klienciNowyNazwiskoTextField;

    @FXML
    private Button klienciDodajKlientaButton;

    @FXML
    private Button klienciUsunButton;

    @FXML
    private TextField klienciNumerTelefonuTextField;

    @FXML
    private TextField klienciNazwiskoTextField;

    @FXML
    private TextField klienciNowyImieTextField;

    @FXML
    private Tab ofertaTabPane;

    @FXML
    private AnchorPane ofertaAnchorPane;

    @FXML
    private TabPane subTabPane;

    @FXML
    private Tab ofertaSprzedazyTabPane;

    @FXML
    private AnchorPane ofertaSprzedazyAnchorPane;

    @FXML
    private ListView<Car> ofertaSprzedazyListView;

    @FXML
    private TextField ofertaSprzedazyMarkaTextField;

    @FXML
    private TextField ofertaSprzedazyModelTextField;

    @FXML
    private TextField ofertaSprzedazyKolorTextField;

    @FXML
    private Label ofertaSprzedazyWyszukajWOfercieLabel;

    @FXML
    private Button ofertaSprzedazySzukajOfertyButton;

    @FXML
    private Label ofertaSprzedazyListViewLabel;

    @FXML
    private Separator ofertaSprzedazySeparator;

    @FXML
    private Button ofertaSprzedazyWszystkieOfertyButton;

    @FXML
    private Button ofertaSprzedazyRezerwujButton;

    @FXML
    private ComboBox<Client> ofertaSprzedazyKlientComboBox;

    @FXML
    private TextField ofertaSprzedazyIloscSztukTextField;

    @FXML
    private Label ofertaSprzedazyErrorLabel;

    @FXML
    private Tab edycjaOfertyTabPane;

    @FXML
    private AnchorPane edycjaOfertyAnchorPane;

    @FXML
    private ListView<Car> edycjaOfertyListView;

    @FXML
    private Label edycjaOfertyListViewLabel;

    @FXML
    private Button edycjaOfertyUsunButton;

    @FXML
    private ComboBox<Model> edycjaOfertyModelComboBox;

    @FXML
    private Label edycjaOfertyDodajOferteLabel;

    @FXML
    private DatePicker edycjaOfertyDatePicker;

    @FXML
    private ComboBox<Color> edycjaOfertyKolorComboBox;

    @FXML
    private ComboBox<Package> edycjaOfertyPakietComboBox;

    @FXML
    private Button edycjaOfertyDodajOferteButton;

    @FXML
    private Separator edycjaOfertySeparator;

    @FXML
    private TextField edycjaOfertyIloscTextField;

    @FXML
    private Label edycjaOfertyDodajDoMagazynuLabel;

    @FXML
    private Button edycjaOfertyDodajButton;

    @FXML
    private Label edycjaOfertyErrorLabel;

    @FXML
    private Tab rezerwacjeTabPane;

    @FXML
    private AnchorPane rezerwacjeAnchorPane;

    @FXML
    private ListView<Reservation> rezerwacjeListView;

    @FXML
    private Label rezerwacjeListViewLabel;

    @FXML
    private TextField rezerwacjeImieTextField;

    @FXML
    private Button rezerwacjeWszystkieRezerwacjeButton;

    @FXML
    private Button rezerwacjeSzukajRezerwacjiButton;

    @FXML
    private Label rezerwacjeWyszukajRezerwacjeLabel;

    @FXML
    private Button rezerwacjeUsunButton;

    @FXML
    private TextField rezerwacjeNazwiskoTextField;

    @FXML
    private Button konsolaZaladujButton;

    @FXML
    private Button konsolaBackupButton;

    @FXML
    private Button konsolaNowyButton;

    @FXML
    void edycjaOfertyDodajButtonClicked(MouseEvent event) {

        int ilosc = isInteger(edycjaOfertyIloscTextField.getText());
        Car car = edycjaOfertyListView.getSelectionModel().getSelectedItem();
        int id = car.getOfertaId();

        if (ilosc > 0 && !car.equals(null)) {
            if (jdbc.dodajDoMagazynu(id, ilosc)) {
                showInfoAlert("Sukces", "Ustalono stan magazynowy");
                jdbc.znajdzWszystkieOferty();

                edycjaOfertyListView.getItems().clear();
                ofertaSprzedazyListView.getItems().clear();
                edycjaOfertyListView.getItems().addAll(Storage.cars);

            } else {
                showErrorAlert("Bład", "Nie udalo sie ");
            }

        } else {
            showErrorAlert("Bład", "Zły ofrmat danych");
        }

        edycjaOfertyIloscTextField.clear();

    }

    @FXML
    void edycjaOfertyDodajOferteButtonClicked(MouseEvent event) {

        Model model = edycjaOfertyModelComboBox.getSelectionModel().getSelectedItem();
        Package pakiet = edycjaOfertyPakietComboBox.getSelectionModel().getSelectedItem();
        Color color = edycjaOfertyKolorComboBox.getSelectionModel().getSelectedItem();
        LocalDate localDate = edycjaOfertyDatePicker.getValue();
        Date date = Date.valueOf(localDate);

        if (!model.equals(null) && !pakiet.equals(null) && !color.equals(null) && !date.equals(null)) {

            if (jdbc.dodajOferte(model.getId(), color.getName(), pakiet.getName(), date)) {
                showInfoAlert("Sukces", "Stworzono nową oferte");

                jdbc.znajdzWszystkieOferty();
                edycjaOfertyListView.getItems().clear();
                edycjaOfertyListView.getItems().addAll(Storage.cars);
                ofertaSprzedazyListView.getItems().clear();

            } else {
                showErrorAlert("Błąd", "Nie udało się stwrzyć nowej oferty");
            }

        } else {
            showErrorAlert("Bład", "Nie wybrano wszystkich wszystkich pól");
        }

        edycjaOfertyModelComboBox.getSelectionModel().clearSelection();
        edycjaOfertyPakietComboBox.getSelectionModel().clearSelection();
        edycjaOfertyKolorComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    void edycjaOfertyUsunButtonClicked(MouseEvent event) {

        Car car = edycjaOfertyListView.getSelectionModel().getSelectedItem();
        int id = car.getOfertaId();

        if (!car.equals(null)) {
            if (jdbc.usunOferte(id)) {
                showInfoAlert("Sukces", "Usunięto oferte");

                Storage.cars.remove(car);
                edycjaOfertyListView.getItems().clear();
                edycjaOfertyListView.getItems().addAll(Storage.cars);
                ofertaSprzedazyListView.getItems().clear();
            } else {
                showErrorAlert("Błąd", "Nie udało się usunąć oferty");
            }

        } else {
            showErrorAlert("Bład", "Nie wybrano oferty");
        }

    }

    @FXML
    void klienciDodajKlientaButtonClicked(MouseEvent event) {

        String firstname = klienciNowyImieTextField.getText();
        String lastname = klienciNowyNazwiskoTextField.getText();
        String phoneNumber = klienciNumerTelefonuTextField.getText();

        ofertaSprzedazyKlientComboBox.getItems().clear();

        if (!firstname.equals("") && !lastname.equals("") && !phoneNumber.equals("")) {
            if (jdbc.dodajKlienta(firstname, lastname, phoneNumber)) {

                klienciListView.getItems().clear();
                showInfoAlert("Sukces", "Dodano klienta");
            } else {
                showErrorAlert("Błąd", "Nie udało się dodać klienta");
            }

        } else {
            showErrorAlert("Błąd", "Nie wypełniono wszystki pól");
        }

        jdbc.znajdzWszystkichKlientow();
        ofertaSprzedazyKlientComboBox.getItems().addAll(Storage.clients);

        klienciNowyImieTextField.clear();
        klienciNowyNazwiskoTextField.clear();
        klienciNumerTelefonuTextField.clear();

        klienciNowyImieTextField.setDisable(true);
        klienciNowyNazwiskoTextField.setDisable(true);
        klienciNumerTelefonuTextField.setDisable(true);

        klienciDodajKlientaButton.setDisable(true);

    }

    @FXML
    void klienciNowyKlientButtonClicked(MouseEvent event) {

        klienciDodajBlad.setText("");
        klienciDodajKlientaButton.setDisable(false);

        klienciNowyImieTextField.setDisable(false);
        klienciNowyNazwiskoTextField.setDisable(false);
        klienciNumerTelefonuTextField.setDisable(false);

    }

    @FXML
    void klienciSzukajKlientaButtonClicked(MouseEvent event) {

        String imie = klienciImieTextField.getText();
        String nazwisko = klienciNazwiskoTextField.getText();

        if (!imie.equals("") || !nazwisko.equals("")) {

            jdbc.znajdzKonkretnegoKlienta(imie, nazwisko);
            klienciListView.getItems().clear();
            klienciListView.getItems().addAll(Storage.clients);

        } else {
            showErrorAlert("Błąd", "Nie podano żadnego kryterium");
        }

    }

    @FXML
    void klienciUsunButtonClicked(MouseEvent event) {

        Client klient = klienciListView.getSelectionModel().getSelectedItem();
        int id = klient.getId();

        if (!klient.equals(null)) {
            if (jdbc.usunKlienta(id)) {
                showInfoAlert("Sukces", "Usunieto model");

                Storage.clients.remove(klient);

                ofertaSprzedazyKlientComboBox.getItems().clear();
                ofertaSprzedazyKlientComboBox.getItems().addAll(Storage.clients);
                klienciListView.getItems().remove(klient);

            } else {
                showErrorAlert("Blad", "Nie udalo sie usunac klienta");
            }
        } else {
            showErrorAlert("Blad", "Nie wybrano modelu");
        }
    }

    @FXML
    void klienciWszyscyKlienciButtonClicked(MouseEvent event) {

        jdbc.znajdzWszystkichKlientow();

        klienciListView.getItems().clear();
        klienciListView.getItems().addAll(Storage.clients);

    }

    @FXML
    void koloryDodajKolorButtonClicked(MouseEvent event) {
        String nazwaNowegoKoloru = koloryNazwaKoloruTextField.getText();
        int cenaNowegoKoloru = isInteger(koloryCenaKoloruTextField.getText());

        if (!nazwaNowegoKoloru.equals("") && cenaNowegoKoloru > 0) {
            if (jdbc.dodajKolor(nazwaNowegoKoloru, cenaNowegoKoloru)) {

                showInfoAlert("Sukces", "Dodano nowy kolor");
                jdbc.znajdzWszystkieKolory();
                edycjaOfertyKolorComboBox.getItems().clear();
                edycjaOfertyKolorComboBox.getItems().addAll(Storage.colors);
                wyswietlWszystkieKolory();
            } else
                showErrorAlert("Błąd", "Nie dodano nowego koloru");
        }

        koloryNazwaKoloruTextField.clear();
        koloryCenaKoloruTextField.clear();
        koloryNazwaKoloruTextField.setDisable(false);
        koloryCenaKoloruTextField.setDisable(false);
        koloryDodajKolorButton.setDisable(false);
    }

    @FXML
    void koloryNowyKolorButtonClicked(MouseEvent event) {
        koloryNazwaKoloruTextField.setDisable(false);
        koloryCenaKoloruTextField.setDisable(false);
        koloryDodajKolorButton.setDisable(false);
    }

    @FXML
    void kolorySzukajKoloruButtonClicked(MouseEvent event) {
        String kolor = koloryKolorTextField.getText();

        koloryListView.getItems().clear();

        if (!kolor.equals("")) {
            jdbc.znajdzKonkretnyKolor(kolor);
            koloryListView.getItems().clear();
            koloryListView.getItems().addAll(Storage.colors);
        }
        koloryKolorTextField.clear();
    }

    @FXML
    void koloryUsunButtonClicked(MouseEvent event) {
        Color kolor = koloryListView.getSelectionModel().getSelectedItem();
        String nazwaKoloru = kolor.getName();

        if (!kolor.equals(null)) {
            if (jdbc.usunKolor(nazwaKoloru)) {
                showInfoAlert("Sukces", "Usunieto wybrany kolor");
                Storage.colors.remove(kolor);
                edycjaOfertyKolorComboBox.getItems().clear();
                wyswietlWszystkieKolory();
                edycjaOfertyKolorComboBox.getItems().addAll(Storage.colors);

            } else {
                showErrorAlert("Błąd", "Nie usunięto koloru");
            }
        }
    }

    @FXML
    void koloryWszystkieKoloryButtonClicked(MouseEvent event) {
        wyswietlWszystkieKolory();
    }

    @FXML
    void modeleDodajModelButtonClicked(MouseEvent event) {

        String marka = modeleMarkaComboBox.getSelectionModel().getSelectedItem().getName();
        String model = modeleNazwaModeluTextField.getText();
        double pojemnosc = isDouble(modelePojemnoscSilnikaTextField.getText());
        int moc = isInteger(modeleMocSilnikaTextField.getText());
        int cena = isInteger(modeleCenaBazowaTextField.getText());

        if (!marka.equals("") && !model.equals("") && pojemnosc > 0 && moc > 0 && cena > 0) {
            if (jdbc.dodajModel(marka, model, pojemnosc, moc, cena)) {
                showInfoAlert("Sukces", "Dodano nowy model");
                modeleListView.getItems().clear();
            } else {
                showErrorAlert("Bład", "Nie udalo sie dodac modelu");
            }
        } else {
            showErrorAlert("Blad", "Wprowadzono zle dane");
        }

        jdbc.znajdzWszystkieModele();
        edycjaOfertyModelComboBox.getItems().clear();
        edycjaOfertyModelComboBox.getItems().addAll(Storage.models);

        modeleNazwaModeluTextField.clear();
        modelePojemnoscSilnikaTextField.clear();
        modeleMocSilnikaTextField.clear();
        modeleCenaBazowaTextField.clear();

        modeleMarkaComboBox.getItems().clear();
        modeleMarkaComboBox.setDisable(true);
        modeleNazwaModeluTextField.setDisable(true);
        modelePojemnoscSilnikaTextField.setDisable(true);
        modeleMocSilnikaTextField.setDisable(true);
        modeleCenaBazowaTextField.setDisable(true);
        modeleDodajModelButton.setDisable(true);

    }

    @FXML
    void modeleNowyModelButtonClicked(MouseEvent event) {

        modeleMarkaComboBox.setDisable(false);
        modeleNazwaModeluTextField.setDisable(false);
        modelePojemnoscSilnikaTextField.setDisable(false);
        modeleMocSilnikaTextField.setDisable(false);
        modeleCenaBazowaTextField.setDisable(false);
        modeleDodajModelButton.setDisable(false);
    }

    @FXML
    void modeleSzukajModeluButtonClicked(MouseEvent event) {

        String marka = modeleMarkaTextField.getText();
        String model = modeleModelTextField.getText();

        modeleListView.getItems().clear();

        if (!(marka.equals("") && model.equals(""))) {
            jdbc.znajdzKonkretnyModel(marka, model);
            modeleListView.getItems().addAll(Storage.models);
        }

        modeleMarkaTextField.clear();
        modeleModelTextField.clear();
    }

    @FXML
    void modeleUsunButtonClicked(MouseEvent event) {

        Model model = modeleListView.getSelectionModel().getSelectedItem();
        int id = model.getId();

        if (!model.equals(null)) {
            if (jdbc.usunModel(id)) {
                showInfoAlert("Sukces", "Usunieto model");

                Storage.models.remove(model);

                edycjaOfertyModelComboBox.getItems().clear();
                modeleListView.getItems().clear();
                edycjaOfertyModelComboBox.getItems().addAll(Storage.models);
                modeleListView.getItems().addAll(Storage.models);

            } else {
                showErrorAlert("Blad", "Nie udalo sie usunac modelu");
            }
        } else {
            showErrorAlert("Blad", "Nie wybrano modelu");
        }

    }

    @FXML
    void modeleWszystkieModeleButtonClicked(MouseEvent event) {
        jdbc.znajdzWszystkieModele();

        modeleListView.getItems().clear();
        modeleListView.getItems().addAll(Storage.models);
    }

    @FXML
    void ofertaSprzedazyRezerwujButtonClicked(MouseEvent event) {

        Client client = ofertaSprzedazyKlientComboBox.getSelectionModel().getSelectedItem();
        Car car = ofertaSprzedazyListView.getSelectionModel().getSelectedItem();
        int ilosc = isInteger(ofertaSprzedazyIloscSztukTextField.getText());

        if (ilosc != -1 && ilosc > 0 && !car.equals(null) && !client.equals(null)) {

            int clientId = client.getId();
            int productId = car.getOfertaId();

            if (jdbc.przeprowadzTransakcje(productId, clientId, ilosc)) {
                showInfoAlert("Sukces", "Zakceptowano rezerwacje");

                rezerwacjeListView.getItems().clear();
                ofertaSprzedazyListView.getItems().clear();
                edycjaOfertyListView.getItems().clear();

                Storage.cars.remove(car);
                car.setAmount(ilosc);
                Storage.cars.add(car);

                ofertaSprzedazyListView.getItems().addAll(Storage.cars);
                edycjaOfertyListView.getItems().addAll(Storage.cars);

            } else {
                showErrorAlert("Niepowodzenie", "Rezerwacja nieudana");
            }

        } else {
            showErrorAlert("Błąd", "Nie uzupełniono wymaganych pól");
        }

        ofertaSprzedazyIloscSztukTextField.clear();
        ofertaSprzedazyKlientComboBox.getSelectionModel().clearSelection();
        ofertaSprzedazyKlientComboBox.setPromptText("klienci");

    }

    @FXML
    void ofertaSprzedazySzukajOfertyButtonClicked(MouseEvent event) {

        String producent = ofertaSprzedazyMarkaTextField.getText();
        String model = ofertaSprzedazyModelTextField.getText();
        String kolor = ofertaSprzedazyKolorTextField.getText();

        ofertaSprzedazyListView.getItems().clear();

        if (!producent.equals("") || !model.equals("") || !kolor.equals("")) {
            jdbc.znajdzKonkretnaOferte(producent, model, kolor);
            ofertaSprzedazyListView.getItems().addAll(Storage.cars);
        }

        ofertaSprzedazyMarkaTextField.clear();
        ofertaSprzedazyModelTextField.clear();
        ofertaSprzedazyKolorTextField.clear();

    }

    @FXML
    void ofertaSprzedazyWszystkieOfertyButtonClicked(MouseEvent event) {

        jdbc.znajdzWszystkieOferty();

        ofertaSprzedazyListView.getItems().clear();

        ofertaSprzedazyListView.getItems().addAll(Storage.cars);

    }

    @FXML
    void pakietyDodajPakietButtonClicked(MouseEvent event) {

        String nazwaNowegoPakietu = pakietyNazwaPakietuTextField.getText();
        int cenaNowegoPakietu = isInteger(pakietyCenaPakietuTextField.getText());

        if (!nazwaNowegoPakietu.equals("") && cenaNowegoPakietu > 0) {
            if (jdbc.dodajPakiet(nazwaNowegoPakietu, cenaNowegoPakietu)) {

                showInfoAlert("Sukces", "Dodano nowy pakiet");
                jdbc.znajdzWszystkiePakiety();
                edycjaOfertyPakietComboBox.getItems().clear();
                edycjaOfertyPakietComboBox.getItems().addAll(Storage.packages);
                wyswietlWszystkiePakiety();
            } else
                showErrorAlert("Błąd", "Nie dodano nowego pakietu");
        }

        pakietyNazwaPakietuTextField.clear();
        pakietyCenaPakietuTextField.clear();
        pakietyNazwaPakietuTextField.setDisable(true);
        pakietyCenaPakietuTextField.setDisable(true);
        pakietyDodajPakietButton.setDisable(true);
    }

    @FXML
    void pakietyNowyPakietButtonClicked(MouseEvent event) {
        pakietyNazwaPakietuTextField.setDisable(false);
        pakietyCenaPakietuTextField.setDisable(false);
        pakietyDodajPakietButton.setDisable(false);
    }

    @FXML
    void pakietySzukajPakietuButtonClicked(MouseEvent event) {

        String pakiet = pakietyPakietTextField.getText();

        pakietyListView.getItems().clear();

        if (!pakiet.equals("")) {
            jdbc.znajdzKonkretnyPakiet(pakiet);
            pakietyListView.getItems().clear();
            pakietyListView.getItems().addAll(Storage.packages);
        }
        pakietyPakietTextField.clear();
    }

    @FXML
    void pakietyUsunButtonClicked(MouseEvent event) {
        Package pakiet = pakietyListView.getSelectionModel().getSelectedItem();
        String nazwaPakietu = pakiet.getName();

        if (!pakiet.equals(null)) {
            if (jdbc.usunPakiet(nazwaPakietu)) {
                showInfoAlert("Sukces", "Usunieto wybrany pakiet");
                Storage.packages.remove(pakiet);
                edycjaOfertyPakietComboBox.getItems().clear();
                wyswietlWszystkiePakiety();
                edycjaOfertyPakietComboBox.getItems().addAll(Storage.packages);

            } else {
                showErrorAlert("Błąd", "Nie usunięto pakietu");
            }
        }
    }

    @FXML
    void pakietyWszystkiePakietyButtonClicked(MouseEvent event) {
        wyswietlWszystkiePakiety();
    }

    @FXML
    void producenciDodajProducentaButtonClicked(MouseEvent event) {
        String nazwaNowegoProducenta = producenciNazwaProducentaTextField.getText();

        if (!nazwaNowegoProducenta.equals("")) {
            if (jdbc.dodajProducenta(nazwaNowegoProducenta)) {

                showInfoAlert("Sukces", "Dodano nowego producenta");
                jdbc.znajdzWszystkichProducentow();
                modeleMarkaComboBox.getItems().clear();
                wyswietlWszystkichProducentow();
                modeleMarkaComboBox.getItems().addAll(Storage.producers);
            } else
                showErrorAlert("Błąd", "Nie dodano nowego producenta");
        }

        producenciNazwaProducentaTextField.clear();
        producenciNazwaProducentaTextField.setDisable(true);
        producenciDodajProducentaButton.setDisable(true);
    }

    @FXML
    void producenciNowyProducentButtonClicked(MouseEvent event) {
        producenciNazwaProducentaTextField.setDisable(false);
        producenciDodajProducentaButton.setDisable(false);
    }

    @FXML
    void producenciSzukajMarkiButtonClicked(MouseEvent event) {

        String producent = producenciMarkaTextField.getText();

        producenciListView.getItems().clear();

        if (!producent.equals("")) {
            jdbc.znajdzKonkretnegoProducenta(producent);
            producenciListView.getItems().clear();
            producenciListView.getItems().addAll(Storage.producers);
        }
        producenciMarkaTextField.clear();
    }

    @FXML
    void producenciUsunButtonClicked(MouseEvent event) {
        Producer producent = producenciListView.getSelectionModel().getSelectedItem();
        String nazwaProducenta = producent.getName();

        if (!producent.equals(null)) {
            if (jdbc.usunProducenta(nazwaProducenta)) {
                showInfoAlert("Sukces", "Usunieto wybranego producenta");
                Storage.producers.remove(producent);
                modeleMarkaComboBox.getItems().clear();
                wyswietlWszystkichProducentow();
                modeleMarkaComboBox.getItems().addAll(Storage.producers);
            } else {
                showErrorAlert("Błąd", "Nie usunięto producenta");
            }
        }
    }

    @FXML
    void producenciWszystkieMarkiButtonClicked(MouseEvent event) {
        wyswietlWszystkichProducentow();
    }

    @FXML
    void rezerwacjeSzukajRezerwacjiButtonClicked(MouseEvent event) {
        String imieKlienta = rezerwacjeImieTextField.getText();
        String nazwiskoKlienta = rezerwacjeNazwiskoTextField.getText();

        rezerwacjeListView.getItems().clear();

        if (!(imieKlienta.equals("") && nazwiskoKlienta.equals(""))) {
            jdbc.znajdzKonkretnaRezerwacje(imieKlienta, nazwiskoKlienta);
            rezerwacjeListView.getItems().clear();
            rezerwacjeListView.getItems().addAll(Storage.reservations);
        }
        rezerwacjeImieTextField.clear();
        rezerwacjeNazwiskoTextField.clear();
    }

    @FXML
    void rezerwacjeUsunButton(MouseEvent event) {
        Reservation rezerwacja = rezerwacjeListView.getSelectionModel().getSelectedItem();
        int id = rezerwacja.getReservationId();

        if (!rezerwacja.equals(null)) {
            if (jdbc.usunRezerwacje(id)) {
                showInfoAlert("Sukces", "Usunięto rezerwacje");

                Storage.reservations.remove(rezerwacja);
                rezerwacjeListView.getItems().remove(rezerwacja);

            } else {
                showErrorAlert("Błąd", "Nie udało się usunąc rezerwacji");
            }

        } else {
            showErrorAlert("Błąd", "Nie wybrano z listy");
        }
    }

    @FXML
    void rezerwacjeWszystkieRezerwacjeButtonClicked(MouseEvent event) {
        wyswietlWszystkieRezerwacje();
    }

    @FXML
    void konsolaBacupButtonClicked(ActionEvent event) {

        if(!jdbc.makeBackup()) {
            showErrorAlert("Błąd krytyczny", "Ta wersja systemu Windows \n nie współpracuje z tym poleceniem");
        }

    }

    @FXML
    void konsolaNowyButtonClicked(ActionEvent event) throws IOException {

        Parent anotherScene = FXMLLoader.load(getClass().getResource("/fxml/registerWindow.fxml"));
        Scene second = new Scene(anotherScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(second);
        window.show();

    }

    @FXML
    void konsolaZaladujButtonClicked(ActionEvent event) {

        if(!jdbc.restoreDatabase()) {
            showErrorAlert("Błąd krytyczny", "Ta wersja systemu Windows \n nie współpracuje z tym poleceniem");
        }

    }

    private int isInteger(String toCheck) {

        try{
            int value = Integer.parseInt(toCheck);
            
            return value;
        }catch(NumberFormatException ex) {

            showErrorAlert("Zły format danych", "Podana wartość to nie liczba");
            return -1;
        }
    }

    private double isDouble(String toCheck) {

        try{
            double value = Double.parseDouble(toCheck);
            
            return value;
        }catch(NumberFormatException ex) {

            showErrorAlert("Zły format danych", "Podana wartość to nie liczba");
            return -1;
        }
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);

            alert.showAndWait();
    }

    private void showInfoAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);

            alert.showAndWait();
    }

    @FXML
    void initialize() {
        
        jdbc = new AdminWindowJDBC();

        Storage.startStorage();


        jdbc.znajdzWszystkichKlientow();
        ofertaSprzedazyKlientComboBox.getItems().addAll(Storage.clients);

        jdbc.znajdzWszystkieOferty();
        edycjaOfertyListView.getItems().addAll(Storage.cars);

        jdbc.znajdzWszystkieModele();
        edycjaOfertyModelComboBox.getItems().addAll(Storage.models);

        jdbc.znajdzWszystkiePakiety();
        edycjaOfertyPakietComboBox.getItems().addAll(Storage.packages);

        jdbc.znajdzWszystkieKolory();
        edycjaOfertyKolorComboBox.getItems().addAll(Storage.colors);

        jdbc.znajdzWszystkichProducentow();
        modeleMarkaComboBox.getItems().addAll(Storage.producers);
    }

    void wyswietlWszystkiePakiety() {
        pakietyListView.getItems().clear();

        jdbc.znajdzWszystkiePakiety();
        pakietyListView.getItems().clear();
        pakietyListView.getItems().addAll(Storage.packages);
    }

    void wyswietlWszystkieKolory() {
        koloryListView.getItems().clear();

        jdbc.znajdzWszystkieKolory();
        koloryListView.getItems().clear();
        koloryListView.getItems().addAll(Storage.colors);
    }
    
    void wyswietlWszystkichProducentow() {
        producenciListView.getItems().clear();

        jdbc.znajdzWszystkichProducentow();
        producenciListView.getItems().clear();
        producenciListView.getItems().addAll(Storage.producers);
    }

    void wyswietlWszystkieRezerwacje() {
        rezerwacjeListView.getItems().clear();

        jdbc.znajdzWszystkieRezerwacje();
        rezerwacjeListView.getItems().clear();
        rezerwacjeListView.getItems().addAll(Storage.reservations);
    }
}