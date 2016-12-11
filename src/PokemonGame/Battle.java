package PokemonGame;

import Pokedex.*;

import java.util.Random;
import java.util.Scanner;


public class Battle {
    public int newBattle(Pokemon Defender, StorageSys team) {
        Scanner scan = new Scanner(System.in);
        Pokemon poke1 = Defender;
        Pokemon poke2 = team.retrievePokemon(0);
        Pokemon Attacker = team.retrievePokemon(0);
        double hp1 = poke1.getHp();
        double hp2 = poke2.getHp();
        boolean choiceLoop = true;
        boolean combat = true;
        while (choiceLoop)
        {
            DrawBattle(Defender,Attacker,hp1,hp2);
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
                                System.out.println(poke2.getName()+" hit "+poke1.getName()+" for"+(int)dmg(atkMove[0],poke1,poke2)+"damage.");
                                hp1-=dmg(atkMove[y],poke2,poke1);
                                System.out.println(poke1.getName()+" hit "+poke2.getName()+" for"+(int)dmg(atkMove[y],poke2,poke1)+"damage.");
                                DrawBattle(Defender,Attacker,hp1,hp2);
                                break;
                            case 2:
                                hp2-=dmg(atkMove[1],poke1,poke2);
                                System.out.println(poke2.getName()+" hit "+poke1.getName()+" for"+(int)dmg(atkMove[0],poke1,poke2)+"damage.");
                                hp1-=dmg(atkMove[y],poke2,poke1);
                                System.out.println(poke1.getName()+" hit "+poke2.getName()+" for"+(int)dmg(atkMove[y],poke2,poke1)+"damage.");
                                DrawBattle(Defender,Attacker,hp1,hp2);
                                break;
                        }
                        if(hp1<=0){
                            System.out.println("You have defeated"+poke1.getName());
                            combat=false;
                            choiceLoop=false;
                            return 1;
                        }
                        else if(hp2<=0){
                            System.out.println(poke2.getName()+" has fainted. You send in the next pokemon on your team.");
                            combat=false;
                            return 2;
                        }
                    }
                    break;
                case 2:
                    Random s = new Random(); // run chance
                    int x = s.nextInt(100);
                    if (x >= 80) {
                        break;
                    } else {
                        System.out.println("You have successfully run from " + poke1.getName());
                        combat=false;
                        choiceLoop=false;
                        return 3;
                    }
                default:
                    System.out.println("Your choice is invalid, please try again.");
                    break;
            }
        }
        return 0;
    }

    public void DrawBattle(Pokemon poke1, Pokemon poke2,double curHp1,double curHp2) {
        double hp1 = poke1.getHp();
        double hp2 = poke2.getHp();
        System.out.println("------------------------------");
        System.out.println(poke1.getName());
        System.out.println("|Lvl:" + poke1.getLevel());
        System.out.println("|HP:" + (int)curHp1+"/"+(int)hp1);
        System.out.println("|--------------------------|");
        System.out.println(poke2.getName());
        System.out.println("|Lvl:" + poke2.getLevel());
        System.out.println("|HP:" + (int)curHp2+"/"+(int)hp2);
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
        System.out.println(moves[0].getType()+" "+moves[0].getMvPower()+" "+moves[0].getType()+" "+moves[0].getEle());
        System.out.println("2."+moves[1].getName());
        System.out.println(moves[1].getType()+" "+moves[1].getMvPower()+" "+moves[1].getType()+" "+moves[1].getEle());
    }

    public double crit(Moves move,Pokemon poke) {
        double modifier = 1;
        Random s = new Random(); // random Crit
        int x = s.nextInt(100);
        if (move.getName() == "Slash" || move.getName() == "Stone Edge") {
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
        if(move.getEle()==poke.getType1()||move.getEle()==poke.getType2()){
            modifier *= 1.5;
        }
        return modifier;
    }
    public double dmg(Moves atkMove,Pokemon poke1,Pokemon poke2){
        PhysDmg hit = new PhysDmg();
        SpeDmg spell = new SpeDmg();
        if(atkMove.getType() == "Phys"){
            return hit.attack(atkMove,poke1,poke2,crit(atkMove,poke2));
        }
        else{
            return spell.attack(atkMove,poke1,poke2,crit(atkMove,poke2));
        }
    }
}
