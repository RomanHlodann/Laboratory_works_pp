package Droid;

import main.Main;

public class Droid {
    String nickname;
    int damage;
    int health;
    int shield = 100;
    String ultimate;
    int ultimateScore = 0;
    String turtleShield = "None";
    String color = Main.ANSI_RESET;

    /**
     * Default constructor with type of name
     * @param nickname
     */
    public Droid(String nickname){
        this.nickname = nickname;
    }

    /**
     * Method where droid get hit
     * @return actual damage
     */
    public int getHit(int damage){
        int actualDamage = 0;
        if(turtleShield.equals("On")){
            System.out.println("Droid.Turtle give shield. 0 damage for " + color + nickname + Main.ANSI_RESET);
            setTurtleShield("None");
            return 0;
        }
        if (shield > 0){
            actualDamage = (int)(damage - damage * (shield * 0.0025));
            shield -= actualDamage * 1.5;
            if(shield < 0){
                shield = 0;
                System.out.println("Shield in " + color + nickname + Main.ANSI_RESET + " was broken... Now you cannot make mistakes");
            }
        }
        else {
            actualDamage = damage;
        }
        this.health -= actualDamage;
        if(health < 0)
            health = 0;
        return actualDamage;
    }

    public int getDamage(){
        return damage;
    }

    /**
     * Update ultimate score
     * @param actualDamage
     */
    public void getActualDamage(int actualDamage){
        if (ultimateScore != 100) {
            ultimateScore += actualDamage * 2;
            if (ultimateScore > 100)
                ultimateScore = 100;
        }
    }
    public String getNickname(){
        return nickname;
    }
    public int getHealth(){return health;}
    public int getUltimateScore(){return ultimateScore;}
    public String getUltimate(){return ultimate;}
    public void setTurtleShield(String str){turtleShield = str;}
    public void setUltimateScore(int i){ultimateScore = i;}
    public void setColor(String color){this.color = color;}
    public String getColor(){return color;}
    public boolean isAlive(){
        return health > 0;
    }

    public String toString() {
        return color + nickname + Main.ANSI_RESET + " health = " + health;
    }
}
