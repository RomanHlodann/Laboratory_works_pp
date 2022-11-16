package Battle;

import Droid.Droid;
import main.Main;

import java.util.Random;

/**
 * Class that produce battle of two droids
 */
public class BattleArena {
    private static Droid firstDroid;
    private static Droid secondDroid;
    public static Droid attacker;
    public static Droid defender;
    private static int currentRound = 0;

    /**
     * Constructor that takes two droids
     * @param firstDroid
     * @param secondDroid
     */
    public BattleArena(Droid firstDroid, Droid secondDroid) {
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
    }

    /**
     * Method asks for outputing in file, use method prepareRound() and doFight()
     * @return winner
     */
    public static Droid startFight1v1(){
        Main.askFile();
        do {
            prepareRound();
            doFight(firstDroid, secondDroid);
            if(!secondDroid.isAlive())
                return firstDroid;
            else if(!firstDroid.isAlive())
                return secondDroid;
        } while(true);
    }

    /**
     * Output current round
     */
    public static void prepareRound(){
        currentRound++;
        System.out.println("-------------------------------------");
        System.out.println("Round " + currentRound);
    }
    /**
     * Fight between two droids
     * @return
     */
    public static void doFight(Droid defender, Droid attacker){
        initFighters(defender, attacker);
        int actualDamage = defender.getHit(attacker.getDamage());
        if (actualDamage > 0) {
            printInfo(defender, actualDamage);
            attacker.getActualDamage(actualDamage);
        }
        if(!defender.isAlive()) {
            System.out.println(defender.getColor() + defender.getNickname() + Main.ANSI_RESET + " is dead");
            return;
        }

        actualDamage = attacker.getHit(defender.getDamage());
        if (actualDamage > 0) {
            printInfo(attacker, actualDamage);
            defender.getActualDamage(actualDamage);
        }
        if(!attacker.isAlive())
            System.out.println(attacker.getNickname() + " is dead");
    }

    /**
     * Who will be first attacker between two droids
     */
    public static void initFighters(Droid droid1, Droid droid2) {
        Random random = new Random();
        if (random.nextBoolean()) {
            attacker = droid1;
            defender = droid2;
        } else {
            attacker = droid2;
            defender = droid1;
        }
    }

    /**
     * Print info about fight
     */
    public static void printInfo(Droid defender, int actualDamage) {
        System.out.println(defender.getColor() +  defender.getNickname() + Main.ANSI_RESET + " get hit with " + actualDamage + " damage");
    }
}
