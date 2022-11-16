package Droid;

import Droid.Droid;
import main.Main;

import java.util.Random;

public class Skeleton extends Droid {
    public Skeleton(String nickname) {
        super(nickname);
        this.damage = 13;
        this.health = 55;
        this.ultimate = "Clone";
    }
    @Override
    public int getHit(int damage) {
        Random random = new Random();
        int tryToAvoidDamage = random.nextInt(3);
        if (tryToAvoidDamage == 1) {
            System.out.println(color + nickname + Main.ANSI_RESET + " make a stepback and didn`t get hit");
            return 0;
        } else
            return super.getHit(damage);
    }
    public void setHealth(int health){
        this.health = health;
    }
    /**
     * Method that print info about type of droid
     */
    public static void printInfo(){
        System.out.println("\nDroid.Droid name - Droid.Skeleton");
        System.out.println("Health = 70\nDamage = 25\nUltimate - Clone");
        System.out.println("Ultimate - makes two skeleton with same health point");
        System.out.println("Conclusion: He has low health, but reflexes and damage on other level. 1 in 4 hit can be avoided");
    }
}
