package PokemonGame;

import Pokedex.Dmg;
import Pokedex.PhysDmg;
import Pokedex.Pokemon;

import java.util.Random;
import java.util.Scanner;


public class Battle {
    public void newBattle(Pokemon Defender, Pokemon Attacker) {
        Scanner scan = new Scanner(System.in);
        Pokemon poke1 = Defender;
        Pokemon poke2 = Attacker;
        boolean continueBattle = true;
        boolean choiceLoop = true;
        while(continueBattle){
            DrawBattle(poke1,poke2);
            while(choiceLoop); {
                DrawMenu();
                switch (scan.nextInt()) {
                    case 1:
                        DrawAttacks();
                        break;
                    case 2:
                        Random s = new Random(); // run chance
                        int x = s.nextInt(100);
                        if(x>=70){
                            break;
                        }
                        else {
                            System.out.println("You have successfully run from"+poke1.getName());
                            choiceLoop = false;
                            break;
                        }
                    default:
                        System.out.println("Your choice is invalid, please try again.");
                        break;
                }
            }
        }
    }
    public void DrawBattle(Pokemon poke1,Pokemon poke2){
        double hp1 = poke1.getHp();
        double hp2 = poke2.getHp();
        System.out.println("------------------------------");
        System.out.println("|Wild Pokemon:"+poke1.getName());
        System.out.println("|Lvl:"+poke1.getLevel());
        System.out.println("|HP:"+DrawHP(poke1.getHp(),hp1));
        System.out.println("|--------------------------|");
        System.out.println("|Your Pokemon"+poke2.getName());
        System.out.println("|Lvl:"+poke2.getLevel());
        System.out.println("|HP:"+DrawHP(poke2.getHp(),hp2));
        System.out.println("|__________________________|");
    }
    public void DrawMenu(){
        System.out.println("|___1.Attack_____2.Run_____|");
        System.out.println("|__________________________|");
    }
    public void DrawAttacks(){

    }
    public String DrawHP(double maxHP,double currentHP){
        if(currentHP%maxHP>=90){
            return "|++++++++++|";
        }
        else if(currentHP%maxHP>=80){
            return "|+++++++++-|";
        }
        else if(currentHP%maxHP>=70){
            return "|++++++++--|";
        }
        else if(currentHP%maxHP>=60){
            return "|+++++++---|";
        }
        else if(currentHP%maxHP>=50){
            return "|++++++----|";
        }
        else if(currentHP%maxHP>=40){
            return "|+++++-----|";
        }
        else if(currentHP%maxHP>=30){
            return "|++++------|";
        }
        else if(currentHP%maxHP>=20){
            return "|+++-------|";
        }
        else if(currentHP%maxHP>=10){
            return "|++--------|";
        }
        else if(currentHP%maxHP>00){
            return "|+---------|";
        }
        else{
            return "|FAINTED|";
        }
    }
}
