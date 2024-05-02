package DataObjects;

public class Pokemon {
    public int pokemonId;
    public String pokemonName;
    public String pokemonDescription;
    public int statID;

    public Pokemon(int pokemonId, String pokemonName, String pokemonDescription, int statID) {
        this.pokemonId = pokemonId;
        this.pokemonName = pokemonName;
        this.pokemonDescription = pokemonDescription;
        this.statID = statID;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonDescription() {
        return pokemonDescription;
    }

    public void setPokemonDescription(String pokemonDescription) {
        this.pokemonDescription = pokemonDescription;
    }

    public int getStatID() {
        return statID;
    }

    public void setStatID(int statID) {
        this.statID = statID;
    }
}
