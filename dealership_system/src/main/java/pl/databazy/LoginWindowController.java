package pl.databazy;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import pl.databazy.jdbc.LoginWindowJDBC;

public class LoginWindowController {

    private LoginWindowJDBC jdbc;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel;

    @FXML
    void loginButtonClicked(ActionEvent event) throws IOException {

        String loginResult = jdbc.loginUser(loginTextField.getText(), passwordTextField.getText());

        if(loginResult.equals("admin")) {
        	login("admin", event);
        }else if(loginResult.equals("dealer")) {
            login("dealer", event);
        }else if(loginResult.equals("sprzedawca")) {
            login("adviser", event);
        }else if(loginResult.equals(null)) {
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText(null);
            alert.setContentText("Nie udało się zalogować \n spróbuj jeszcze raz");

            alert.showAndWait();

        }
    }

    @FXML
    void initialize() {

        jdbc = new LoginWindowJDBC();

    }

    private void login(String type, ActionEvent event) throws IOException {

        Parent anotherScene = FXMLLoader.load(getClass().getResource("/fxml/"+type+"Window.fxml"));
        Scene second = new Scene(anotherScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(second);
        window.show();

    }

}