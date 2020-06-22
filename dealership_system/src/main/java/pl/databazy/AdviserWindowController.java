package pl.databazy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import pl.databazy.data.Car;
import pl.databazy.data.Client;
import pl.databazy.data.Producer;
import pl.databazy.data.Storage;
import pl.databazy.jdbc.AdviserWindowJDBC;

public class AdviserWindowController {

    private AdviserWindowJDBC jdbc;

    @FXML
    private AnchorPane producentNameTextField;

    @FXML
    private Button allProducerButton;

    @FXML
    private TextField producerTextField;

    @FXML
    private Button concreteProducerButton;

    @FXML
    private ListView<Producer> producersListView;

    @FXML
    private Button allOfferButton;

    @FXML
    private Button concreteOfferButton;

    @FXML
    private TextField offerProducerTextField;

    @FXML
    private TextField modelTextField;

    @FXML
    private TextField colorTextField;

    @FXML
    private ListView<Car> offerListView;

    @FXML
    private TextField amuntTextField;

    @FXML
    private ComboBox<Client> chooseClientComboBox;

    @FXML
    private Button bookButton;

    @FXML
    private TextField newFirstNameTextField;

    @FXML
    private TextField newLastNameTextField;

    @FXML
    private TextField newNumberTextField;

    @FXML
    private Label createClientErrorLabel;

    @FXML
    private Button newClientButton;

    @FXML
    void allOfferButtonClicked(ActionEvent event) {
        jdbc.getAllCars();

        offerListView.getItems().clear();

        offerListView.getItems().addAll(Storage.cars);
    }

    @FXML
    void allProducerButtonClicked(ActionEvent event) {
        jdbc.getAllProducers();

        producersListView.getItems().clear();
        producersListView.getItems().addAll(Storage.producers);
    }

    @FXML
    void bookButtonClicked(ActionEvent event) {

        Client client = chooseClientComboBox.getSelectionModel().getSelectedItem();
        Car car = offerListView.getSelectionModel().getSelectedItem();
        int amount = isInteger(amuntTextField.getText());

        if(amount != -1 && amount > 0 && !car.equals(null) && !client.equals(null)) {
            
            int clientId = client.getId();
            int productId = car.getId();

            if(jdbc.makeTransaction(productId, clientId, amount)){
                showInfoAlert("Sukces", "Zakceptowano rezerwacje");

                offerListView.getItems().clear();

                Storage.cars.remove(car);
                car.setAmount(amount);
                Storage.cars.add(car);

                offerListView.getItems().addAll(Storage.cars);
            } else {
                showErrorAlert("Niepowodzenie", "Rezerwacja nieudana");
            }

        } else {
            System.out.println("Transakcja sie nie udala");
        }

        amuntTextField.clear();
        chooseClientComboBox.getSelectionModel().clearSelection();
        chooseClientComboBox.setPromptText("klienci");
    }

    @FXML
    void concreteOferButtonClicked(ActionEvent event) {

        String producer = offerProducerTextField.getText();
        String model = modelTextField.getText();
        String color = colorTextField.getText();

        offerListView.getItems().clear();

        if(!(producer.equals("") && model.equals("") && color.equals(""))) {
            jdbc.getConcreteCar(producer, model, color);
            offerListView.getItems().addAll(Storage.cars);
        }

        offerProducerTextField.clear();
        modelTextField.clear();
        colorTextField.clear();
    }

    @FXML
    void concreteProducerButtonClicked(ActionEvent event) {
        String producer = producerTextField.getText();

        producersListView.getItems().clear();
        Storage.producers.clear();

        if(!producer.equals("")) {


            jdbc.getConcreteProducer(producer);
           producersListView.getItems().addAll(Storage.producers);

           producerTextField.clear();
           producerTextField.setPromptText("marka");
        }else {
            producerTextField.clear();
            producerTextField.setPromptText("marka");
        }
    }

    @FXML
    void newClientButtonClicked(ActionEvent event) {
        String firstname = newFirstNameTextField.getText();
        String lastname = newLastNameTextField.getText();
        String phoneNumber = newNumberTextField.getText();

        chooseClientComboBox.getItems().clear();

        if(!firstname.equals("") && !lastname.equals("") && !phoneNumber.equals("")) {
            if(jdbc.addClient(firstname, lastname, phoneNumber)) {
                showInfoAlert("Sukces", "Stworzono nowego klienta");
            } else {
                showErrorAlert("Błąd", "Nie udało sie stworzyć klienta");
            }

        } else {
            showErrorAlert("Błąd", "Nie podano wszystkich danych");
        }

        jdbc.getClient();
        chooseClientComboBox.getItems().addAll(Storage.clients);

        newFirstNameTextField.clear();
        newLastNameTextField.clear();
        newNumberTextField.clear();
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
        assert producentNameTextField != null : "fx:id=\"producentNameTextField\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert allProducerButton != null : "fx:id=\"allProducerButton\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert producerTextField != null : "fx:id=\"producerTextField\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert concreteProducerButton != null : "fx:id=\"concreteProducerButton\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert producersListView != null : "fx:id=\"producersListView\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert allOfferButton != null : "fx:id=\"allOfferButton\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert concreteOfferButton != null : "fx:id=\"concreteOfferButton\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert offerProducerTextField != null : "fx:id=\"offerProducerTextField\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert modelTextField != null : "fx:id=\"modelTextField\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert colorTextField != null : "fx:id=\"colorTextField\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert offerListView != null : "fx:id=\"offerListView\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert amuntTextField != null : "fx:id=\"amuntTextField\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert chooseClientComboBox != null : "fx:id=\"chooseClientComboBox\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert bookButton != null : "fx:id=\"bookButton\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert newFirstNameTextField != null : "fx:id=\"newFirstNameTextField\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert newLastNameTextField != null : "fx:id=\"newLastNameTextField\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert newNumberTextField != null : "fx:id=\"newNumberTextField\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert createClientErrorLabel != null : "fx:id=\"createClientErrorLabel\" was not injected: check your FXML file 'adviserWindow.fxml'.";
        assert newClientButton != null : "fx:id=\"newClientButton\" was not injected: check your FXML file 'adviserWindow.fxml'.";


        jdbc = new AdviserWindowJDBC();

        Storage.startStorage();

        jdbc.getClient();
        chooseClientComboBox.getItems().addAll(Storage.clients);
    }
}
