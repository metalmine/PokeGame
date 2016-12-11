package PokemonGame;

import Pokedex.Pokemon;

import java.util.Random;

public class Encounter {
    private int AreaID;

    public Pokemon wildPoke(int ID) {
        Random s = new Random();
        int x = s.nextInt(100);
        int p = 0;
        this.AreaID = ID;
        switch (AreaID) {
            case 0:
                if (x > 60) {
                    p = 13;
                } else {
                    p = 4;
                }
                break;
            case 1:
                if (x > 95) {
                    p = 13;
                } else {
                    p = 5;
                }
                break;
            case 2:
                if (x > 90) {
                    p = 13;
                } else {
                    p = 6;
                }
                break;
            case 3:
                if (x > 90) {
                    p = 13;
                } else {
                    p = 7;
                }
                break;
            case 4:
                if (x > 90) {
                    p = 7;
                } else {
                    p = 8;
                }
                break;
            case 5:
                if (x > 90) {
                    p = 8;
                } else {
                    p = 9;
                }
                break;
            case 6:
                if (x > 95) {
                    p = 10;
                } else {
                    p = 11;
                }
                break;
            case 7:
                if (x > 90) {
                    p = 13;
                } else {
                    p = 12;
                }
                break;
        }
        Pokemon wildPokemon = new Pokemon(p);
        return wildPokemon;
    }
}
