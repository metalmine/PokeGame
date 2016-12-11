package PokemonGame;

import Pokedex.*;

import java.util.Random;
import java.util.Scanner;


public class Battle {
    public void newBattle(Pokemon Defender, Pokemon Attacker) {
        Scanner scan = new Scanner(System.in);
        Pokemon poke1 = Defender;
        Pokemon poke2 = Attacker;
        double hp1 = poke1.getHp();
        double hp2 = poke2.getHp();
        boolean continueBattle = true;
        boolean choiceLoop = true;
        boolean combat = true;
        while (continueBattle) {
            DrawBattle(poke1, poke2);
            while (choiceLoop) ;
            {
                DrawMenu();
                switch (scan.nextInt()) {
                    case 1:
                        while(combat){
                            Moves[] atkMove = poke2.getMoves();
                            DrawAttacks(poke2);
                            Random s = new Random(); // defending pokemon's attack
                            int x = s.nextInt(100);
                            int y;
                            if(x>=50){
                                y=0;
                            }else{
                                y=1;
                            }
                            switch (scan.nextInt()){
                                case 1:
                                    hp2-=dmg(atkMove[0],poke1,poke2);
                                    hp1-=dmg(atkMove[y],poke2,poke1);
                                    break;
                                case 2:
                                    hp2-=dmg(atkMove[1],poke1,poke2);
                                    hp1-=dmg(atkMove[y],poke2,poke1);
                                    break;
                            }
                            if(hp1<=0){
                                System.out.println("You have defeated"+poke1.getName());
                                combat=false;
                            }
                            else if(hp2<=0){
                                System.out.println(poke2.getName()+" has fainted. You send in the next pokemon on your team.");

                            }
                        }
                        break;
                    case 2:
                        Random s = new Random(); // run chance
                        int x = s.nextInt(100);
                        if (x >= 70) {
                            break;
                        } else {
                            System.out.println("You have successfully run from" + poke1.getName());
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

    public void DrawBattle(Pokemon poke1, Pokemon poke2) {
        double hp1 = poke1.getHp();
        double hp2 = poke2.getHp();
        System.out.println("------------------------------");
        System.out.println("|Wild Pokemon:" + poke1.getName());
        System.out.println("|Lvl:" + poke1.getLevel());
        System.out.println("|HP:" + DrawHP(poke1.getHp(), hp1));
        System.out.println("|--------------------------|");
        System.out.println("|Your Pokemon" + poke2.getName());
        System.out.println("|Lvl:" + poke2.getLevel());
        System.out.println("|HP:" + DrawHP(poke2.getHp(), hp2));
        System.out.println("|__________________________|");
    }

    public void DrawMenu() {
        System.out.println("You can:");
        System.out.println("1. Attack");
        System.out.println("2. Run");
        System.out.println("3. Catch");
    }

    public void DrawAttacks(Pokemon poke) {
        Moves[] moves = poke.getMoves();
        System.out.println("1."+moves[0].getName());
        System.out.println(moves[0].getType()+moves[0].getMvPower()+moves[0].getType()+moves[0].getEle());
        System.out.println("2."+moves[1].getName());
        System.out.println(moves[1].getType()+moves[1].getMvPower()+moves[1].getType()+moves[1].getEle());
    }

    public String DrawHP(double maxHP, double currentHP) {
        if (currentHP % maxHP >= 90) {
            return "|++++++++++|";
        } else if (currentHP % maxHP >= 80) {
            return "|+++++++++-|";
        } else if (currentHP % maxHP >= 70) {
            return "|++++++++--|";
        } else if (currentHP % maxHP >= 60) {
            return "|+++++++---|";
        } else if (currentHP % maxHP >= 50) {
            return "|++++++----|";
        } else if (currentHP % maxHP >= 40) {
            return "|+++++-----|";
        } else if (currentHP % maxHP >= 30) {
            return "|++++------|";
        } else if (currentHP % maxHP >= 20) {
            return "|+++-------|";
        } else if (currentHP % maxHP >= 10) {
            return "|++--------|";
        } else if (currentHP % maxHP > 00) {
            return "|+---------|";
        } else {
            return "|FAINTED|";
        }
    }

    public double crit(String move) {
        double modifier = 1;
        Random s = new Random(); // random Crit
        int x = s.nextInt(100);
        if (move == "Slash" || move == "Stone Edge") {
            if (x < 20) {
                modifier *= 1.5;
            }
        } else {
            if (x < 10) {
                modifier *= 1.5;
            }
        }
        Random d = new Random();
        int y = d.nextInt(15);
        modifier *= (0.8 + (y / 100));
        return modifier;
    }
    public double dmg(Moves atkMove,Pokemon poke1,Pokemon poke2){
        PhysDmg hit = new PhysDmg();
        SpeDmg spell = new SpeDmg();
        if(atkMove.getType() == "Phys"){
            return hit.attack(atkMove,poke1,poke2,crit(atkMove.getName()));
        }
        else{
            return spell.attack(atkMove,poke1,poke2,crit(atkMove.getName()));
        }
    }
}
