package Battle;

import Battle.BattleArena;
import Battle.DroidTeam;
import Droid.*;
import main.Main;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class, where team fights
 */
public class BattleArenaTeams {
    DroidTeam Team1, Team2;
    ArrayList<Droid> TeamA;
    ArrayList<Droid> TeamB;
    static int clones = 1;

    /**
     * Constructor that get teams
     */
    public BattleArenaTeams(DroidTeam TeamA, DroidTeam TeamB){
        Team1 = TeamA;
        Team2 = TeamB;
        this.TeamA = TeamA.Droids;
        this.TeamB = TeamB.Droids;
    }

    /**
     * Method that produces fight
     * @return team winner
     */
    public DroidTeam fight(){
        Random random = new Random();
        Main.askFile();
        do {
            checkUltimate();
            BattleArena.prepareRound();
            for (int i = 0; i < TeamA.size(); i++) {
                if(TeamB.isEmpty()){break;}
                int opponent = (int)(Math.random() * TeamB.size());
                BattleArena.doFight(TeamA.get(i), TeamB.get(opponent));
                if(!TeamA.get(i).isAlive())
                    TeamA.remove(i);
                if(!TeamB.get(opponent).isAlive())
                    TeamB.remove(opponent);
                System.out.println();
            }
        }while (!TeamA.isEmpty() && !TeamB.isEmpty());
        if(!TeamA.isEmpty())
            return Team1;
        else return Team2;
    }

    /**
     * Method that checks whether in team has someone ultimate
     */
    public void checkUltimate(){
        for(int i = 0; i < TeamA.size(); i++){
            if(TeamA.get(i).getUltimateScore() == 100)
                useUltimate(TeamA.get(i), TeamA, TeamB);
        }
        for(int i = 0; i < TeamB.size(); i++){
            if(TeamB.get(i).getUltimateScore() == 100)
                useUltimate(TeamB.get(i), TeamB, TeamA);
        }
    }

    /**
     * Method that gives opportunity to droid to use his ultimate
     * @param droid droid that wanna use ultimate
     * @param team1 team of droid
     * @param opponent team of opponent
     */
    public void useUltimate(Droid droid, ArrayList<Droid> team1, ArrayList<Droid> opponent){
        droid.setUltimateScore(0);
        switch(droid.getUltimate()){
            case("Clone"):
                System.out.println("\n" + droid.getColor() + droid.getNickname() + Main.ANSI_RESET + " uses ultimate and created one more skeleton");
                Skeleton newDroid = new Skeleton("clone" + Integer.toString(clones++));
            newDroid.setHealth(droid.getHealth());
            newDroid.setColor(droid.getColor());
            team1.add(newDroid);
            break;

            case("Traitor"):
                System.out.println("\n" + droid.getColor() + droid.getNickname() + Main.ANSI_RESET + " uses ultimate and make opponents fight!");
                Droid droid1 = TeamB.get(0);
                for(Droid i: opponent)
                    if(droid1.getHealth() < i.getHealth())
                        droid1 = i;
                for(Droid i: opponent){
                    if(i != droid1){
                        BattleArena.doFight(droid1, i);
                        return;
                    }
                }
                System.out.println("But not enough opponents(");
                break;

            case("Shield - power"):
                System.out.println("\n" + droid.getColor() + droid.getNickname() + Main.ANSI_RESET + " uses ultimate and give mates shield for 1 hit!");
                for(Droid i: team1)
                    i.setTurtleShield("On");
        }
    }
}
