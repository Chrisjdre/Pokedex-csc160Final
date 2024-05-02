package com.example.cscfinal;

import DataAccess.PokemonDataAccess;
import DataObjects.Type;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        PokemonDataAccess pokemonDataAccess = new PokemonDataAccess();

//        List<Pokemon> pokemons = new ArrayList<>();
//        pokemons = pokemonDataAccess.getAllPokemon();
//
//        for (Pokemon pokemon: pokemons) {
//            System.out.println(pokemon.getPokemonName());
//            System.out.println(pokemon.getPokemonDescription());
//        }
        System.out.println(pokemonDataAccess.getPokemonStats(1).specialAttack);

        List<Type> types = new ArrayList<>();
        types = pokemonDataAccess.getPokemonTypes(2);

        for (Type type: types) {
            System.out.println(type.typeName);
        }

    }
}
