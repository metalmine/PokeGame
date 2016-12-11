package PokemonGame;

import Pokedex.Pokemon;

import java.util.Random;

public class Encounter {
    private int AreaID;
    public Pokemon wildPoke(int ID){
        Random s = new Random();
        int x = s.nextInt(100);
        int P = 0;
        this.AreaID = ID;
        switch(AreaID){
            case 0:
                if(x>60){
                    P = 13;
                }
                else{
                    P = 4;
                }
                break;
            case 1:
                if(x>95){
                    P = 13;
                }
                else{
                    P = 5;
                }
                break;
            case 2:
                if(x>90){
                    P = 13;
                }
                else{
                    P = 6;
                }
                break;
            case 3:
                if(x>90){
                    P = 13;
                }
                else{
                    P = 7;
                }
                break;
            case 4:
                if(x>90){
                    P = 7;
                }
                else{
                    P = 8;
                }
                break;
            case 5:
                if(x>90){
                    P = 8;
                }
                else{
                    P = 9;
                }
                break;
            case 6:
                if(x>95){
                    P = 10;
                }
                else{
                    P = 11;
                }
                break;
            case 7:
                if(x>90){
                    P = 13;
                }
                else{
                    P = 12;
                }
                break;
        }
        Pokemon wildPokemon = new Pokemon(P);
        return wildPokemon;
    }
}
