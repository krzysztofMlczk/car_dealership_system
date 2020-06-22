package pl.databazy;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application 
{
    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        Parent mainPane = FXMLLoader.load(getClass().getResource("/fxml/loginWindow.fxml"));
        Scene scene = new Scene(mainPane);
        stage.setTitle("Databazy");
        stage.setScene(scene);
        stage.show();
    }
}