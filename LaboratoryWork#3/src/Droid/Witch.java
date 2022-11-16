package Droid;

import Droid.Droid;
import main.Main;

import java.util.Random;

public class Witch extends Droid {
    public Witch(String nickname){
        super(nickname);
        this.damage = 10;
        this.health = 100;
        this.ultimate = "Traitor";
    }
    @Override
    public int getHit(int damage){
        Random random = new Random();
        int tryToAvoidDamage = random.nextInt(4);
        if (tryToAvoidDamage == 1){
            System.out.println(color + nickname + Main.ANSI_RESET + " make a stepback and didn`t get hit");
            return 0;
        }
        else
            return super.getHit(damage);
    }
    /**
     * Method that print info about type of droid
     */
    public static void printInfo(){
        System.out.println("\nDroid.Droid name - Droid.Witch");
        System.out.println("Health = 100\nDamage = 10\nUltimate - traitor");
        System.out.println("When she gets enough points for ultimate, she can make opponent to fight against his mates");
        System.out.println("Conclusion: She has interesting ultimate, but reflexes are bad. Only 1 in 5 hit can be avoided");
    }
}
