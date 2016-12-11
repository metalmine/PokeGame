package Pokedex;

import Pokedex.Moves;

import java.util.Random;

public class Pokemon {
    private int id;
    private int level;
    private String name;
    private String specie;
    private String colour;
    private String type1;
    private String type2;
    private char gender;
    private int currentExp;
    private int totalExp;
    private double hp;
    private double atk;
    private double def;
    private double spA;
    private double spD;
    private double spe;
    final Moves[] moves = new Moves[2];

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getSpe() {
        return spe;
    }

    public void setSpe(double spe) {
        this.spe = spe;
    }

    public double getSpD() {

        return spD;
    }

    public void setSpD(double spD) {
        this.spD = spD;
    }

    public double getSpA() {

        return spA;
    }

    public void setSpA(double spA) {
        this.spA = spA;
    }

    public double getDef() {

        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public double getAtk() {

        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType2() {
        return type2;
    }

    public String getType1() {
        return type1;
    }

    public String getColour() {
        return colour;
    }

    public String getSpecie() {

        return specie;
    }

    public String getName() {

        return name;
    }

    public int getLevel() {

        return level;
    }

    public char getGender() {
        return gender;
    }

    public void getSummary() {
        System.out.println("+++++++++++++++++++");
        System.out.printf("|Name:%-12s\n|", this.getName());
        System.out.printf("|Specie:%-10s\n|", this.getSpecie());
        System.out.printf("|Level:%011d\n|", this.getLevel());
        System.out.printf("|Gender:%-10c\n|", this.getGender());
        System.out.printf("|Type1:%-11s\n|", this.getType1());
        System.out.printf("|Type2:%-11s\n|", this.getType2());
        System.out.printf("|Colour:%-10s\n|", this.getColour());
        System.out.println("+++++++++++++++++++");
    }

    public Pokemon() {
        this.id = 0;
        this.level = 0;
        this.name = "N/A";
        this.specie = "N/A";
        this.colour = "N/A";
        this.type1 = "N/A";
        this.type2 = "N/A";
        this.gender = 'n';
    }

    public Pokemon(int id) {
        Random s = new Random(); // random gender
        int x = s.nextInt(100);
        if (x < 15) {
            this.gender = 'f';
        } else {
            this.gender = 'm';
        }
        this.level = id;
        switch (id) {
            case 1:

                this.level = 5;
                this.specie = "Bulbasaur";
                this.name = specie;
                this.type1 = "Grass";
                this.type2 = "-";
                this.colour = "Green";
                this.hp = (this.level*2);
                this.atk = (this.level*0.92);
                this.def = (this.level*0.92);
                this.spA = (this.level*1.21);
                this.spD = (this.level*1.21);
                this.spe = (this.level*0.85);
                this.moves[0] = Moves(0);
                break;
            case 2:
                this.level = 5;
                this.specie = "Charmander";
                this.name = specie;
                this.type1 = "Fire";
                this.type2 = "-";
                this.colour = "Orange";
                this.hp = (this.level*1.88);
                this.atk = (this.level*0.98);
                this.def = (this.level*0.81);
                this.spA = (this.level*1.12);
                this.spD = (this.level*0.94);
                this.spe = (this.level*1.21);
                break;
            case 3:
                this.level = 5;
                this.specie = "Squirtle";
                this.name = specie;
                this.type1 = "Water";
                this.type2 = "-";
                this.colour = "Blue";
                this.hp = (this.level*1.98);
                this.atk = (this.level*0.90);
                this.def = (this.level*1.21);
                this.spA = (this.level*0.94);
                this.spD = (this.level*1.19);
                this.spe = (this.level*0.81);
                break;
            case 4:
                this.level = 7;
                this.specie = "Pikachu";
                this.name = specie;
                this.type1 = "Electric";
                this.type2 = "-";
                this.colour = "Yellow";
                this.hp = (this.level*2);
                this.atk = (this.level*0.92);
                this.def = (this.level*0.92);
                this.spA = (this.level*1.21);
                this.spD = (this.level*1.21);
                this.spe = (this.level*0.85);
                break;
            case 5:
                this.level = 9;
                this.specie = "Pidgey";
                this.name = specie;
                this.type1 = "Normal";
                this.type2 = "Flying";
                this.colour = "White";
                this.hp = (this.level*1.80);
                this.atk = (this.level*1.03);
                this.def = (this.level*0.76);
                this.spA = (this.level*0.94);
                this.spD = (this.level*0.94);
                this.spe = (this.level*1.66);
                break;
            case 6:
                this.level = 13;
                this.specie = "Ghastly";
                this.name = specie;
                this.type1 = "Ghost";
                this.type2 = "Poison";
                this.colour = "Purple";
                this.hp = (this.level*1.70);
                this.atk = (this.level*0.67);
                this.def = (this.level*0.58);
                this.spA = (this.level*1.84);
                this.spD = (this.level*0.67);
                this.spe = (this.level*1.48);
                break;
            case 7:
                this.level = 16;
                this.specie = "Kadabra";
                this.name = specie;
                this.type1 = "Psychic";
                this.type2 = "-";
                this.colour = "Purple";
                this.hp = (this.level*1.90);
                this.atk = (this.level*0.67);
                this.def = (this.level*0.58);
                this.spA = (this.level*2.20);
                this.spD = (this.level*1.30);
                this.spe = (this.level*1.93);
                break;
            case 8:
                this.level = 18;
                this.specie = "Scyther";
                this.name = specie;
                this.type1 = "Bug";
                this.type2 = "Flying";
                this.colour = "Green";
                this.hp = (this.level*2.5);
                this.atk = (this.level*2.02);
                this.def = (this.level*1.48);
                this.spA = (this.level*1.03);
                this.spD = (this.level*1.48);
                this.spe = (this.level*1.93);
                break;
            case 9:
                this.level = 21;
                this.specie = "Onix";
                this.name = specie;
                this.type1 = "Ground";
                this.type2 = "Rock";
                this.colour = "Grey";
                this.hp = (this.level*1.80);
                this.atk = (this.level*0.85);
                this.def = (this.level*2.92);
                this.spA = (this.level*0.58);
                this.spD = (this.level*0.85);
                this.spe = (this.level*1.30);
                break;
            case 10:
                this.level = 30;
                this.specie = "Dragonair";
                this.name = specie;
                this.type1 = "Dragon";
                this.type2 = "-";
                this.colour = "Blue";
                this.hp = (this.level*2.32);
                this.atk = (this.level*1.55);
                this.def = (this.level*1.21);
                this.spA = (this.level*1.30);
                this.spD = (this.level*1.30);
                this.spe = (this.level*1.30);
                break;
            case 11:
                this.level = 35;
                this.specie = "Snorlax";
                this.name = specie;
                this.type1 = "Normal";
                this.type2 = "-";
                this.colour = "Blue";
                this.hp = (this.level*4.30);
                this.atk = (this.level*2.02);
                this.def = (this.level*1.21);
                this.spA = (this.level*1.21);
                this.spD = (this.level*2.02);
                this.spe = (this.level*0.58);
                break;
            case 12:
                this.level = 40;
                this.specie = "Articuno";
                this.name = specie;
                this.type1 = "Ice";
                this.type2 = "Flying";
                this.colour = "Blue";
                this.hp = (this.level*2.90);
                this.atk = (this.level*1.57);
                this.def = (this.level*1.84);
                this.spA = (this.level*1.75);
                this.spD = (this.level*2.29);
                this.spe = (this.level*1.57);
                break;
            case 13:
                this.level = 1;
                this.specie = "Zubat";
                this.name = specie;
                this.type1 = "Bug";
                this.type2 = "Flying";
                this.colour = "Blue";
                this.hp = (this.level*1.90);
                this.atk = (this.level*0.85);
                this.def = (this.level*0.67);
                this.spA = (this.level*0.58);
                this.spD = (this.level*0.76);
                this.spe = 100;
                break;

        }
    }
}
