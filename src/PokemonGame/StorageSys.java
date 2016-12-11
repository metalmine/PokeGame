package PokemonGame;

import Pokedex.Pokemon;

public class StorageSys {
    private final Pokemon[] storage = new Pokemon[6];

    public void addPokemon(Pokemon pokemon, int team) {
        storage[team] = pokemon;
    }

    public Pokemon retrievePokemon(int poke) {
        return storage[poke];
    }

    public void movePokemon(int team1, int team2) {
        if (null == storage[team1]) {
            System.out.println("No pokemon to move.");
        } else if (null != storage[team1] && null != storage[team2]) {
            Pokemon tempPoke2 = storage[team2];
            storage[team2] = storage[team1];
            storage[team1] = tempPoke2;
        } else {
            storage[team2] = storage[team1];
            releasePokemon(team1);
        }
    }

    public void releasePokemon(int team) {
        storage[team] = null;
    }

    public void getSummary(int poke) {
        storage[poke].getSummary();
    }
}