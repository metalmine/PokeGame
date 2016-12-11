package PokemonGame;

import Pokedex.Pokemon;


public class Battle {
    public Battle(Pokemon Defender, Pokemon Attacker) {
        Pokemon Poke1 = Defender;
        Pokemon Poke2 = Attacker;
        while(true){

            break;
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
        System.out.println("|___1.Attack_____2.Run_____|");
        System.out.println("|__________________________|");
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
