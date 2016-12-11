package Pokedex;

import java.util.Random;

public class Moves {
    private int mvPower;
    private int priority;
    private int mvAcc;
    private String type;

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

    public double crit(){
        double modifier=1;
        Random s = new Random(); // random Crit
        int x = s.nextInt(100);
        if (x < 10) {
            modifier*=1.5;
        }
        Random d = new Random();
        int y = d.nextInt(15);
        modifier*=(0.8+(y/100));
        return modifier;
    }
    public Moves(int moveID){
        switch(moveID){
            case 0:
                this.mvPower=40;
                this.priority=1;
                this.mvAcc=100;
                this.type="Physical";
                break;


        }
    }
}