package PokemonGame;

import Pokedex.Pokemon;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) { // Game main loop
        Scanner scan = new Scanner(System.in);
        Trainer mc = new Trainer();
        StorageSys BillsPC = new StorageSys();
        int choice = 0;
        boolean running = true;
        StorageSys mainTrainer = new StorageSys();
        mc.setTeamID(mainTrainer);
        while (running) {
            if (null == mc.getTeamID().retrievePokemon(0)) {
                createTrainer(mc);
                System.out.println("Which pokemon would you like to start with?");
                System.out.println("************************************************");
                System.out.println("*    >Grass<          >Fire<        >Water<    *");
                System.out.println("************************************************");
                System.out.println("*|  1.Bulbasaur |  2.Charmander|  3.Squirtle  |*");
                System.out.println("************************************************");
                while (choice <= 0 || choice > 3) {
                    choice = scan.nextInt();
                    if (choice <= 0 || choice > 3) {
                        System.out.println("Your selection is out of bounds, please try again.\nPress ENTER to CONTINUE.");
                        scan.nextLine();
                    }
                }
                switch (choice) {
                    case 1:
                        Pokemon starterBulba = new Pokemon(1);
                        mc.getTeamID().addPokemon(starterBulba, 0);
                        break;
                    case 2:
                        Pokemon starterCharm = new Pokemon(2);
                        mc.getTeamID().addPokemon(starterCharm, 0);
                        break;
                    case 3:
                        Pokemon starterSquir = new Pokemon(3);
                        mc.getTeamID().addPokemon(starterSquir, 0);
                        break;
                }
            }
            System.out.println("What would you like to do?");
            System.out.println("1. Walk into the tall grass");
            System.out.println("2. Access the PC");
            System.out.println("3. Exit game");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    Encounter wildEncounter = new Encounter();
                    Battle wildBattle = new Battle();
                    wildBattle.newBattle(wildEncounter.wildPoke(1), mc.getTeamID().retrievePokemon(0));
                    break;
                case 2:
                    pc(BillsPC, mc.getTeamID());
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }

    private static void pc(StorageSys PC, StorageSys Team) { // PC system main loop.
        int choice = 0;
        int PCBox = 1;
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("What would you like to do?");
            System.out.println("1. Deposit a pokemon");
            System.out.println("2. Withdraw a pokemon");
            System.out.println("3. Release a pokemon");
            System.out.println("4. Check a Pokemon's Information");
            System.out.println("5. Exit PC");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    int teamSlot = 1;
                    Pokemon teamPoke;
                    Pokemon pcPoke;
                    System.out.println("Which Pokemon would you like to deposit?");
                    for (int i = 1; i < 6; i++) {
                        teamPoke = Team.retrievePokemon(i - 1);
                        System.out.print("Slot " + i + ": ");
                        if (0 == teamPoke.getLevel()) {
                            System.out.println(i + ") EMPTY");
                        } else {
                            System.out.println(i + ") " + teamPoke.getName());
                        }
                    }
                    teamPoke = Team.retrievePokemon(scan.nextInt());

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    Team.getSummary(0);
                    break;
                case 5:
                    System.out.println("Thank you for using the Pokemon Storage System!\nCome back anytime!");
                    running = false;
                    break;
            }
        }
    }

    private static void createTrainer(Trainer mc) {
        int choice;
        char agree;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the World of Pokemon!");
        System.out.println("What is your name?");
        int confirm = 1; // Checks for [y/n] agreement adherence.
            mc.setName(scan.nextLine());
            while (confirm == 1) {
            System.out.println("Is your name " + mc.getName() + "? [y/n]]");
            agree = scan.nextLine().charAt(0);
            if (agree == 'y' || agree == 'Y' || agree == 'n' || agree == 'N') {
                confirm = 0;
            } else {
                System.out.println("You have entered an invalid input, try again.\nPress ENTER to CONTINUE.");
            }
        }
    }
}
