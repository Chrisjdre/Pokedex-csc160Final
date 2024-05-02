package DataAccess;

import DataObjects.Pokemon;
import DataObjects.Stats;
import DataObjects.Type;
import DataObjects.Weakness;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDataAccess {

    public List<Pokemon> getAllPokemon(){
        List<Pokemon> pokemons = new ArrayList<>();
        ConnectDB conn = new ConnectDB();

        try(Connection connection = conn.getConnection()){
            if (connection != null) {
                // Step 1: make a statement (Statement or PreparedStatement)
                Statement statement = connection.createStatement();
                // Step 2: Execute a query (plain SQL or stored procedure) and return the results
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Pokemon");
                // Step 3: Get data from the results
                while(resultSet.next()) {
                    int id = resultSet.getInt("PokemonID");
                    String pokemonName = resultSet.getString("PokemonName");
                    String pokemonDescription = resultSet.getString("PokemonDescription");
                    int statID = resultSet.getInt("StatID");

                    Pokemon pokemon = new Pokemon(id,pokemonName,pokemonDescription,statID);
                    pokemons.add(pokemon);
                }
                resultSet.close();
                statement.close();
            }
        }catch (SQLException e){
            System.out.println("Get pokemon failed failed");
            System.out.println(e.getMessage());
        }
        return pokemons;
    }

    public Pokemon getPokemonbyID(int pokemonID) {
        Pokemon pokemon = null;
        ConnectDB conn = new ConnectDB();

        try(Connection connection = conn.getConnection()){
            if (connection != null) {
                // Step 1: make a statement (Statement or PreparedStatement)
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Pokemon WHERE PokemonID = ?");

                statement.setInt(1,pokemonID);

                ResultSet resultSet = statement.executeQuery();

                // Step 3: Get data from the results
                if(resultSet.next()){
                    int id = resultSet.getInt("PokemonID");
                    String pokemonName = resultSet.getString("PokemonName");
                    String pokemonDescription = resultSet.getString("PokemonDescription");
                    int statID = resultSet.getInt("StatID");

                    pokemon = new Pokemon(id,pokemonName,pokemonDescription,statID);
                }

                resultSet.close();
                statement.close();
            }
        }catch (SQLException e){
            System.out.println("Get pokemon failed failed");
            System.out.println(e.getMessage());
        }



        return pokemon;
    }
    public Pokemon getPokemonbyName(String pokemonName){
        Pokemon pokemon = null;
        ConnectDB conn = new ConnectDB();

        try(Connection connection = conn.getConnection()){
            if (connection != null) {
                // Step 1: make a statement (Statement or PreparedStatement)
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Pokemon WHERE PokemonName = ?");

                statement.setString(1,pokemonName);

                ResultSet resultSet = statement.executeQuery();

                // Step 3: Get data from the results
                if(resultSet.next()){
                    int id = resultSet.getInt("PokemonID");
                    String pokemonNamesql = resultSet.getString("PokemonName");
                    String pokemonDescription = resultSet.getString("PokemonDescription");
                    int statID = resultSet.getInt("StatID");

                    pokemon = new Pokemon(id,pokemonName,pokemonDescription,statID);
                }

                resultSet.close();
                statement.close();
            }
        }catch (SQLException e){
            System.out.println("Get pokemon failed failed");
            System.out.println(e.getMessage());
        }



        return pokemon;
    }

    public Stats getPokemonStats(int statID) {
        Stats stats = null;
        ConnectDB conn = new ConnectDB();

        try(Connection connection = conn.getConnection()){
            if (connection != null) {
                // Step 1: make a statement (Statement or PreparedStatement)
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Stats WHERE StatID = ?");

                statement.setInt(1,statID);

                ResultSet resultSet = statement.executeQuery();

                // Step 3: Get data from the results
                if(resultSet.next()){
                    int statsID = resultSet.getInt("StatID");
                    int attack = resultSet.getInt("Attack");
                    int specialAttack = resultSet.getInt("SpecialAttack");
                    int defense = resultSet.getInt("Defense");
                    int specialDefense = resultSet.getInt("SpecialDefense");
                    int speed = resultSet.getInt("Speed");
                    int healthPoints = resultSet.getInt("HitPoints");



                    stats = new Stats(statsID,attack,specialAttack,defense,specialDefense,speed,healthPoints);
                }

                resultSet.close();
                statement.close();
            }
        }catch (SQLException e){
            System.out.println("Get pokemon failed failed");
            System.out.println(e.getMessage());
        }

        return stats;
    }

    public List<Type> getPokemonTypes(int pokemonID){
        List<Type> types = new ArrayList<>();
        ConnectDB conn = new ConnectDB();



        try(Connection connection = conn.getConnection()){
            if (connection != null) {
                // Step 1: make a statement (Statement or PreparedStatement)
//                PreparedStatement statement = connection.prepareStatement("SELECT * FROM PokemonTypes JOIN TABLE ( Type ) WHERE PokemonID = ?");
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM PokemonType JOIN Type  on PokemonType.TypeID = Type.TypeID WHERE PokemonID = ?");
                statement.setInt(1,pokemonID);

                ResultSet resultSet = statement.executeQuery();

                // Step 3: Get data from the results
                while (resultSet.next()){
                    int id = resultSet.getInt("PokemonID");
//                    int typeID = resultSet.getInt("Type.TypeID");
                    int typeID = 1;
                    String typeName = resultSet.getString("TypeName");
                    String typeDescription= resultSet.getString("TypeDescription");

                    Type type = new Type(typeID,typeName,typeDescription);
                    types.add(type);
                }

                resultSet.close();
                statement.close();
            }
        }catch (SQLException e){
            System.out.println("Get types failed ");
            System.out.println(e.getMessage());
        }


        return types;
    }

    public List<Weakness> getPokemonWeaknesses(int pokemonID){
        List<Weakness> weaknesses = new ArrayList<>();
        ConnectDB conn = new ConnectDB();



        try(Connection connection = conn.getConnection()){
            if (connection != null) {
                // Step 1: make a statement (Statement or PreparedStatement)
//                PreparedStatement statement = connection.prepareStatement("SELECT * FROM PokemonTypes JOIN TABLE ( Type ) WHERE PokemonID = ?");
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM PokemonWeakness JOIN Weakness  on PokemonWeakness.WeaknessID = Weakness.WeaknessID WHERE PokemonID = ?");
                statement.setInt(1,pokemonID);

                ResultSet resultSet = statement.executeQuery();

                // Step 3: Get data from the results
                while (resultSet.next()){
                    int id = resultSet.getInt("PokemonID");
//                    int typeID = resultSet.getInt("Type.TypeID");
                    int weaknessID = 1;
                    String weaknessName = resultSet.getString("WeaknessName");
                    String weaknessDescription= resultSet.getString("WeaknessDescription");

                    Weakness weakness = new Weakness(weaknessID,weaknessName,weaknessDescription);
                    weaknesses.add(weakness);
                }

                resultSet.close();
                statement.close();
            }
        }catch (SQLException e){
            System.out.println("Get types failed ");
            System.out.println(e.getMessage());
        }


        return weaknesses;
    }


}
