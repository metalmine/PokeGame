package Pokedex;
import java.util.Random;

public class PhysDmg extends Dmg{
    public double damage(Moves attack, Pokemon defender, Pokemon Attacker,double modifier){
        double damage = ((((2*defender.getLevel()+10)/(250))*((Attacker.getAtk())/(defender.getDef()))*(attack.getMvPower())+2)*modifier);
        return damage;
    }
}
