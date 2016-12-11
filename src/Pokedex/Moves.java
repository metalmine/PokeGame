package Pokedex;

import java.util.Random;

public class Moves {
    private String name;
    private int mvPower;
    private int priority;
    private int mvAcc;
    private String type;
    private int pp;
    private String ele;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPp() {

        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getMvPower() {
        return mvPower;
    }

    public void setMvPower(int mvPower) {
        this.mvPower = mvPower;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMvAcc() {
        return mvAcc;
    }

    public void setMvAcc(int mvAcc) {
        this.mvAcc = mvAcc;
    }



    private String[] names = {"Quick Attack", "Tackle", "Hyper Beam", "Heavy Slam", "Aerial Ace",
            "Razor Leaf", "Ice Beam", "Flame Thrower", "Liquidation", "Hydro Pump", "Vacuum Wave", "Slash", "X-Scissor",
            "Lightning Bolt", "Volt Tackle", "Sucker Punch", "Shadow Ball", "Stone Edge", "Rock Blast","Leech Life"};
    private int[] powers = {40, 45, 60, 80, 60, 65, 80, 80, 80, 120, 40, 70, 80, 80, 140, 80, 90, 15};
    private int[] priorities = {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2};
    private int[] accuracies = {100,100,60,80,100,95,100,100,100,70,100,100,100,100,60,100,100,100,100,100};
    private String[] types = {"Phys", "Phys", "Spec", "Phys", "Phys", "Spec", "Spec", "Spec", "Phys", "Spec", "Phys",
            "Phys", "Phys", "Spec", "Phys", "Phys", "Phys", "Spec", "Phys"};
    private int[] pps = {10,10,2,5,5,5,4,4,5,2,10,7,5,5,3,2,5,5,10,20};


    // Constructor
    public Moves(int moveID) {
        this.name = names[moveID];
        this.mvPower = powers[moveID];
        this.priority = priorities[moveID];
        this.mvAcc = accuracies[moveID];
        this.type = types[moveID];
        this.pp = pps[moveID];
    }
}