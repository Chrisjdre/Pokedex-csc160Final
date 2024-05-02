package com.example.cscfinal;

import DataAccess.PokemonDataAccess;
import DataObjects.Pokemon;
import DataObjects.Stats;
import DataObjects.Type;
import DataObjects.Weakness;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PokemonInfoController {
    public PokemonDataAccess pokemonDataAccess = new PokemonDataAccess();

    public Label lblPokemonName;
    public Text txtHitpoints;

    public Text txtAttack;
    public Text txtDefense;
    public Text txtSpAttack;
    public Text txtSpDefense;
    public Text txtSpeed;
    public ProgressBar pgrsHitPoints;
    public ProgressBar pgrsAttack;
    public ProgressBar pgrsDefense;
    public ProgressBar pgrsSpAttack;
    public ProgressBar pgrsSpDefense;
    public ProgressBar pgrsSpeed;
    public Pokemon selectedPokemon;
    public Stats pokemonStats;
    public ListView lstType;
    public ListView lstWeakness;




    void initData(Pokemon currentPokemon) {
        selectedPokemon = currentPokemon;
        lblPokemonName.setText(selectedPokemon.pokemonName);
        pokemonStats = pokemonDataAccess.getPokemonStats(currentPokemon.statID);

        txtAttack.setText(String.valueOf(pokemonStats.attack));
        txtDefense.setText(String.valueOf(pokemonStats.defense));
        txtHitpoints.setText(String.valueOf(pokemonStats.healthPoints));
        txtSpAttack.setText(String.valueOf(pokemonStats.specialAttack));
        txtSpDefense.setText(String.valueOf(pokemonStats.specialDefense));
        txtSpeed.setText(String.valueOf(pokemonStats.speed));

        pgrsAttack.setProgress(((double)pokemonStats.attack / 10));
        pgrsDefense.setProgress(((double)pokemonStats.defense / 10));
        pgrsHitPoints.setProgress(((double)pokemonStats.healthPoints / 10));
        pgrsSpAttack.setProgress(((double)pokemonStats.specialAttack / 10));
        pgrsSpDefense.setProgress(((double)pokemonStats.specialDefense / 10));
        pgrsSpeed.setProgress(((double)pokemonStats.speed / 10));

        List<Type> types = pokemonDataAccess.getPokemonTypes(currentPokemon.pokemonId);

        ArrayList<String> ar = new ArrayList<String>();
        for (DataObjects.Type type:types) {
            ar.add(type.getTypeName());
        }
        ar.toArray();
        lstType.getItems().addAll(ar);

        List<Weakness> weaknesses = pokemonDataAccess.getPokemonWeaknesses(currentPokemon.pokemonId);

        ArrayList<String> weaknessar = new ArrayList<String>();
        for (DataObjects.Weakness weakness:weaknesses) {
            weaknessar.add(weakness.getWeaknessName());
        }
        weaknessar.toArray();
        lstWeakness.getItems().addAll(weaknessar);

    }

}
