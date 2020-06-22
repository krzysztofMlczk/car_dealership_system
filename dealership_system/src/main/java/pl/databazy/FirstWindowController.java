package pl.databazy;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FirstWindowController {

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    void RegisterButtonClicked(ActionEvent event) throws IOException {

        Parent anotherScene = FXMLLoader.load(getClass().getResource("/fxml/registerWindow.fxml"));
        Scene second = new Scene(anotherScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(second);
        window.show();

    }

    @FXML
    void loginButtonClicked(ActionEvent event) throws IOException {

        Parent anotherScene = FXMLLoader.load(getClass().getResource("/fxml/adminWindow.fxml"));
        Scene second = new Scene(anotherScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(second);
        window.show();

    }

}