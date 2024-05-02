package com.example.cscfinal;
import DataAccess.PokemonDataAccess;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Pokemon implements Initializable{

    public Button btnMoreInfo;
    PokemonDataAccess pokemonDataAccess = new PokemonDataAccess();
    List<DataObjects.Pokemon> pokemons = pokemonDataAccess.getAllPokemon();

    public String currentPokemon;

    public ImageView pokemonImage;
    public TextArea pokemonDescription;
    public Label lblPokemon;
    @FXML
    private ListView<String> pokemonList;





    public void onMoreInfoButtonClick(ActionEvent event) {
        DataObjects.Pokemon selectedPokemon = pokemonDataAccess.getPokemonbyName(currentPokemon);
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Pokedex.class.getResource("PokemonInfo.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            PokemonInfoController controller = fxmlLoader.getController();
            controller.initData(selectedPokemon);

            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(currentPokemon == null){
            btnMoreInfo.setVisible(false);
        }
        pokemonImage.setImage(new Image("C:\\Users\\mraut\\CSC-160\\cscFinal\\src\\main\\resources\\Pictures\\pokemon-default.jpg"));
        ArrayList<String> ar = new ArrayList<String>();
        for (DataObjects.Pokemon pokemon:pokemons) {
            ar.add(pokemon.getPokemonName());
        }
        ar.toArray();
        pokemonList.getItems().addAll(ar);

        pokemonList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                btnMoreInfo.setVisible(true );
                currentPokemon = pokemonList.getSelectionModel().getSelectedItem();

                DataObjects.Pokemon selectedPokemon = pokemonDataAccess.getPokemonbyName(currentPokemon);
                pokemonImage.setImage(new Image("C:\\Users\\mraut\\CSC-160\\cscFinal\\src\\main\\resources\\Pictures\\"+ currentPokemon + ".png"));

                pokemonDescription.setText(selectedPokemon.pokemonDescription);
                lblPokemon.setText(selectedPokemon.pokemonName);
            }
        });

    }


}

