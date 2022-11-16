package main;

import Battle.*;
import Droid.*;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    // colors for graphic output
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Main method, where program starts. Use method that asks what user want to do
     */
    public static void main(String[] args) {
        chooseMethod();
    }

    /**
     * Method that asks what to do: 1v1 or Team on Team. Directs to method, which users said.
     */
    public static void chooseMethod() {
        while(true)
        {
            System.out.println("What would u like to do?");
            System.out.print("1 - 1v1\n2- Team Battle\n0 - Exit\nYour choice - ");
            Scanner in = new Scanner(System.in);
            char choose = in.next().charAt(0);
            if(choose == '1') {
                PVP();
                return;
            }
            if(choose == '2') {
                TeamBattle();
                return;
            }
            if(choose == '0')
                return;
            System.out.println("Inputed wrong value. Try again!");
        }
    }

    /**
     * Method that creates 2 droids and object of class, where they will fight
     */
    public static void PVP(){
        Scanner in = new Scanner(System.in);
        System.out.print("Which two droids you wanna pvp? ( 1 - Witch, 2- Skeleton, 3 - Turtle ) - ");
        String symb = in.nextLine();
        System.out.print("Name droid - ");
        String name = in.nextLine();
        Droid droid1 = chooseDroid(symb, name);

        System.out.print("Second droid - ");
        symb = in.nextLine();
        System.out.print("Name droid - ");
        name = in.nextLine();
        Droid droid2 = chooseDroid(symb, name);

        BattleArena battle = new BattleArena(droid1, droid2);
        Droid winner = battle.startFight1v1();
        System.out.println("\nWinner of this game is " + winner.getNickname());
        System.out.println("Health = " + winner.getHealth());
    }

    /**
     * Method that create object of teams and object of battle between them
     */
    public static void TeamBattle(){
        Scanner in = new Scanner(System.in);
        System.out.print("How many players should be in a team (min - 2, max 7) - ");
        int count = 0;
        while(true) {
            count = checkInt();
            if(count >= 2 && count <= 7)
                break;
        }

        System.out.print("\nTeamname - ");
        String teamName = in.nextLine();
        DroidTeam TeamA = new DroidTeam(teamName, count, ANSI_GREEN);

        System.out.print("\nSecond Teamname - ");
        teamName = in.nextLine();
        DroidTeam TeamB = new DroidTeam(teamName, count, ANSI_RED);

        BattleArenaTeams battle = new BattleArenaTeams(TeamA,TeamB);
        printWinners(battle.fight());
    }

    /**
     * Method that asks to output in file or no
     */
    public static void askFile(){
        System.out.println("Would u like to write battle to file? (Y/N)");
        Scanner in = new Scanner(System.in);
        if(in.nextLine().equals("Y")){
            try {
                PrintStream fileStream = new PrintStream("E:\\Lab3.txt");
                System.setOut(fileStream);
            }
            catch(Exception e) {
                e.getStackTrace();
            }
        }
    }

    /**
     * Method that returns necessary droid
     * @param i - which one of object
     * @param name - name of droid
     */
    public static Droid chooseDroid(String i, String name) {
        switch (i){
            case ("1"): return new Witch(name);
            case ("2"): return new Skeleton(name);
            case ("3"): return new Turtle(name);
            default: return new Droid(name);
        }
    }

    /**
     * Method that print team winner
     * @param droid
     */
    public static void printWinners(DroidTeam droid){
        System.out.println("Winners of this game - " + droid.getColor() + droid.getTeamName() + Main.ANSI_RESET);
        System.out.println("Droids:");
        for(int i = 0; i < droid.getCopyArray().size(); i++)
            System.out.println(droid.getCopyArray().get(i));
    }

    /**
     * Method that returns input Integer
     */
    public static int checkInt(){
        Scanner in = new Scanner(System.in);
        String numb = in.nextLine();
        while(true) {
            try {
                int value = Integer.parseInt(numb);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Inputed wrong value! Try again");
            }
        }
    }
}
