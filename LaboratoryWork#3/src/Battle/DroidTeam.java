package Battle;

import Droid.*;
import main.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class DroidTeam {
    ArrayList<Droid> Droids = new ArrayList<Droid>();
    ArrayList<Droid> CopyOfArray;
    String teamName;
    String color;

    /**
     * Constructor of team
     * @param teamName
     * @param count count of droids in team
     * @param color which color team will be reproduced
     */
    public DroidTeam(String teamName, int count, String color){
        this.teamName = teamName;
        createTeam(count);
        setColors(color);
    }

    /**
     * Method that creates team
     * @param count count of droids in team
     */
    void createTeam(int count){
        Scanner in = new Scanner(System.in);
        System.out.print("Would you like to see draft? (Y/N) - ");
        String s = in.nextLine();
        if(s.equals("Y")){
            Witch.printInfo();
            Skeleton.printInfo();
            Turtle.printInfo();
        }
        System.out.println("\nChoose Team");
        for (int i = 0; i < count; i++){
            System.out.print("What droid you wanna have in team? ( 1 - Witch, 2- Skeleton, 3 - Turtle ) - ");
            String symb = in.nextLine();
            System.out.print("Name droid - ");
            String name = in.nextLine();
            Droids.add(Main.chooseDroid(symb, name));
        }
        CopyOfArray = new ArrayList<>(Droids);
    }

    /**
     * Set team color
     * @param color
     */
    void setColors(String color){
        for(Droid i: Droids){
            i.setColor(color);
        }
        this.color = color;
    }
    public String getTeamName(){return teamName;}
    public ArrayList getCopyArray(){return CopyOfArray;}
    public String getColor(){return color;}
}
