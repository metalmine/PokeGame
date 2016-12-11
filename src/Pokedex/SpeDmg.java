package Pokedex;

public class SpeDmg extends Dmg{
    public double attack(Moves attack, Pokemon defender, Pokemon Attacker,double modifier){
        double damage = ((((2*defender.getLevel()+10)/(250))*((Attacker.getSpA())/(defender.getSpD()))*(attack.getMvPower())+2)*modifier);
        return damage;
    }
}
