package PokemonGame;

import Pokedex.Pokemon;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) { // Game main loop
        Scanner scan = new Scanner(System.in);
        Trainer[] trainers = new Trainer[100];
        StorageSys BillsPC = new StorageSys();
        int choice = 0;
        boolean running = true;
        StorageSys mainTrainer = new StorageSys();
        trainers[0].setTeamID(mainTrainer);
        while (running) {
            if (null == trainers[0]) {
                createTrainer(trainers);
                System.out.println("Which pokemon would you like to start with?");
                System.out.println("************************************************");
                System.out.println("*    >Grass<          >Fire<        >Water<    *");
                /*System.out.println("************************************************");
                System.out.println("*|      /^^\\  1|      /---\\   |              |*");
                System.out.println("*| /`---'\\  \\2|     / @ @ |  |              |*");
                System.out.println("*|/ @  @  \\ / 1|    ^ \\  w  /   |              |*");
                System.out.println("*|\\  W    /  | |   \\ \\ \\  |   |              |*");
                System.out.println("*| ̅¯V¯̅¯̅¯̅\\V̅¯̅¯̅¯̅̅V1|    \\ \\/    |  |              |*");
                System.out.println("*|              |              |              |*");*/
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
                        trainers[0].getTeamID().addPokemon(starterBulba, 0);
                        break;
                    case 2:
                        Pokemon starterCharm = new Pokemon(2);
                        trainers[0].getTeamID().addPokemon(starterCharm, 0);
                        break;
                    case 3:
                        Pokemon starterSquir = new Pokemon(3);
                        trainers[0].getTeamID().addPokemon(starterSquir, 0);
                        break;
                }
            }
            System.out.println("What would you like to do?");
            System.out.println("1. Walk into the tall grass");
            System.out.println("2. Access the PC");
            System.out.println("3. Exit game");
            choice = scan.nextInt();
            scan.nextLine();
            if (choice == 3) {
                running = false;
            } else {
                switch (choice) {
                    case 1:
                        Encounter wildEncounter = new Encounter();
                        Battle wild = new Battle(wildEncounter.wildPoke(1), trainers[0].getTeamID().retrievePokemon(0));
                        break;
                    case 2:
                        pc(BillsPC, trainers[0].getTeamID());
                        break;
                    case 3:
                        break;
                }
            }
        }
    }

    private static void pc(StorageSys PC, StorageSys Team) { // PC system main loop.
        int choice = 0;
        int PCBox = 1;
        Scanner scan = new Scanner(System.in);

        while (true) {
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
                    break;
            }
        }
    }

    private static void createTrainer(Trainer[] trainers) {
        int choice;
        char agree;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the World of Pokemon!");
        System.out.println("What is your name?");
        int confirm = 1; // Checks for [y/n] agreement adherence.
        while (true) {
            trainers[0].setName(scan.nextLine());
            while (confirm == 1) {
                System.out.println("Is your name " + trainers[0].getName() + "? [y/n]]");
                agree = scan.nextLine().charAt(0);
                if (agree == 'y' || agree == 'Y' || agree == 'n' || agree == 'N') {
                    confirm = 0;
                } else {
                    System.out.println("You have entered an invalid input, try again.\nPress ENTER to CONTINUE.");
                }
            }
        }
    }
}
