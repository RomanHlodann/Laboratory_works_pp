package Droid;

import Droid.Droid;
import main.Main;

import java.util.Random;

public class Turtle extends Droid {
    public Turtle(String nickname) {
        super(nickname);
        this.damage = 7;
        this.health = 130;
        this.ultimate = "Shield - power";
    }
    @Override
    public int getHit(int damage) {
        Random random = new Random();
        int tryToAvoidDamage = random.nextInt(5);
        if (tryToAvoidDamage == 1) {
            System.out.println(color + nickname + Main.ANSI_RESET + " make a stepback and didn`t get hit");
            return 0;
        } else
            return super.getHit(damage);
    }

    /**
     * Method that print info about type of droid
     */
    public static void printInfo(){
        System.out.println("\nDroid.Droid name - Droid.Turtle");
        System.out.println("Health = 140\nDamage = 7\nUltimate - Shield power");
        System.out.println("Ultimate - for round no one get hit");
        System.out.println("Conclusion: He has low damage, reflexes are bad, but high health and helping teammates " +
                "replace all disadvantages. 1 in 6 hit can be avoided");
    }
}
