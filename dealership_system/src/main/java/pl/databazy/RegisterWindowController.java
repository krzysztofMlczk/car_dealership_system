package pl.databazy;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import pl.databazy.jdbc.RegisterWindowJDBC;

public class RegisterWindowController {

    private RegisterWindowJDBC jdbc;

    @FXML
    private TextField loginField;

    @FXML
    private ComboBox<String> userTypeComboBox;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField secondPasswordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button registerButton;

    @FXML
    private Button cancleButton;

    ObservableList<String> userTypes = FXCollections.observableArrayList(
        "Dealer",
        "Sprzedawca"
    );

    @FXML
    void cancelButtonClicked(ActionEvent event) throws IOException {
        
        returnToFirstWindow(event);

    }

    @FXML
    void registerButtonClicked(ActionEvent event) throws IOException {

        String login = loginField.getText();
        String password = passwordField.getText();
        String secondPassword = secondPasswordField.getText();
        String type = userTypeComboBox.getSelectionModel().getSelectedItem();

        if(!login.equals("") && !password.equals("") && password.equals(secondPassword) && !type.equals(null)) {

            if(jdbc.createUser(login, password, type)) {

                showInfoAlert("Sukces", "Stworzono nowego użytkownika");
                
                returnToFirstWindow(event);

            } else {
                showErrorAlert("Błąd", "Nie udało się stworzyć nowego użytkownik");
            }

        } else {
            showErrorAlert("Błąd", "Wystąpiła niezgodność danych");

            loginField.clear();
            passwordField.clear();
            secondPasswordField.clear();

        }

        loginField.setPromptText("login");
        passwordField.setPromptText("hasło");
        secondPasswordField.setPromptText("powtórz hasło");

    }

    private void returnToFirstWindow(ActionEvent event) throws IOException {
        Parent anotherScene = FXMLLoader.load(getClass().getResource("/fxml/adminWindow.fxml"));
        Scene second = new Scene(anotherScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(second);
        window.show();
    }

    @FXML
    void initialize() {

        userTypeComboBox.setItems(userTypes);

        jdbc = new RegisterWindowJDBC();
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

}
