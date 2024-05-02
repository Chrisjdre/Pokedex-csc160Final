package com.example.cscfinal;

import DataObjects.Pokemon;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class Pokedex extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Pokedex.class.getResource("Pokemon.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Pokedex");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
