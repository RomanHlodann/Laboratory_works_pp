package Main;

import PhoneUser.PhoneUser;
import java.util.Scanner;


public class Main {
    static Scanner in = new Scanner(System.in);
    static int count = 0; // amount of users

    /**
     * Main method, from where program starts
     * @param args is a command line
     */
    public static void main(String[] args) {
        final int MAX_CONSUMERS = 100;
        PhoneUser[] arrayOfConsumers = new PhoneUser[MAX_CONSUMERS]; // array of objects (users)
        map(arrayOfConsumers);
    }

    /**
     * Method that adds user to array
     * @param arrayOfConsumers array of users
     * this method call constructor with paramater, and methods that return values for this constructor
     */
    private static void addConsumers(PhoneUser[] arrayOfConsumers){
        arrayOfConsumers[count++] = new PhoneUser(intValuesForUser("id"), nameUser("surname"),
                nameUser("name"),nameUser("middle name"),phoneUser(),
                intValuesForUser("time of city talks(in minutes)"),intValuesForUser("time of country talks(in minutes)"));
    }

    /**
     * Method that asking for inputing int value
     * @param type - is name of variable we`re looking for
     * @return value
     * calling method checkInt for check if value was inputed correctly
     */
    private static int intValuesForUser(String type){
        while(true){
            System.out.print("Input " + type + ": ");
            String temp = in.nextLine();
            if (Check.checkInt(temp)) {
                int value = Integer.parseInt(temp);
                if (value >= 0)
                    return value;
                else
                    System.out.println("Inputed not correct value. Try again.");
            }
            else {
                System.out.println("Inputed not integer. Try again.");
            }
        }
    }
    /**
     * Method that asking for inputing name/surname/middle name
     * @param find - is name of variable we`re looking for
     * @return value
     * calling method checkName for check if value was inputed correctly
     */
    private static String nameUser(String find){
        while(true){
            System.out.print("Input " + find + ": ");
            String value = in.nextLine();
            if (Check.checkName(value)){
                return value;
            }
            else
                System.out.println("Name inputed incorrectly. Try again.");
        }
    }
    /**
     * Method that asking for inputing phone number
     * @return value
     * calling method checkPhoneNumber for check if value was inputed correctly
     */
    private static String phoneUser(){
        while(true) {
            System.out.print("Input full phone number:");
            String value = in.nextLine();
            if(Check.checkPhoneNumber(value)) {
                return value;
            }
            else
                System.out.println("Inputed wrong number. Try to type with +380");
        }
    }

    /**
     * Method that outputing all users
     * @param arr - array of all users
     */
    private static void showConsumers(PhoneUser[] arr){
        if (arr.length == 0){
            System.out.println("Not founded any consumers");
        }
        else{
            for(int i = 0; i < count; i++){
                System.out.println(arr[i]);
            }
        }
    }
    /**
     * Method that outputing all users in which city talks is higher than preset
     * @param arr - array of all users
     */
    private static void filteredByPresetCityTalks(PhoneUser[] arr, int pres){
        int n = 0;
        for(int i = 0; i < count; i++){
            if(arr[i].getTimeOfCity() > pres)
                System.out.println(arr[i]);
        }
        if(n == 0)
            System.out.println("Was`nt founded any users");
    }
    /**
     * Method that outputing all users, that were using country talk
     * @param arr - array of all users
     */
    private static void filteredByCountryTalks(PhoneUser[] arr){
        int n = 0;
        for(int i = 0; i < count; i++){
            if(arr[i].getTimeOfCountry() > 0) {
                System.out.println(arr[i]);
                n++;
            }
        }
        if(n == 0)
            System.out.println("Was`nt founded any users");
    }
    /**
     * Method that outputing all users, whose number is in range
     * @param arr - array of all users
     * @param min - minimal phone number
     * @param max - maximal phone number
     */
    private static void phoneNumberDiap(PhoneUser[] arr, String min, String max) {
        int n = 0;
        for(int i = 0; i < count; i++){
            if((arr[i].getNumber()).compareTo(min) > 0)
                if((arr[i].getNumber()).compareTo(max) < 0)
                    System.out.println(arr[i]);
        }
        if(n == 0)
            System.out.println("Was`nt founded any users");
    }
    private static void checkIfNumberHasNumbs(String numbs){

    }

    /**
     * Map of program that shows what u can do in console
     * and calling appropriate methods
     * @param arrayOfConsumers - array of users
     */
    private static void map(PhoneUser[] arrayOfConsumers){
        System.out.println("Type 1 - Add consumer\n 2 - Show consumers\n" +
                "3 - Show consumers, in which city talks is higher than preset\n" +
                "4 - Show consumers, that were using country talk\n" +
                "5 - Show consumers, whose number is in range");
        while(true) {
            System.out.print("\nYour answer: ");
            String num = in.nextLine();
            switch (num) {
                case ("1"):
                    addConsumers(arrayOfConsumers);
                    break;
                case ("2"):
                    showConsumers(arrayOfConsumers);
                    break;
                case("3"):
                    int pres = intValuesForUser("time of city talks:");
                    filteredByPresetCityTalks(arrayOfConsumers, pres);
                    break;
                case("4"):
                    filteredByCountryTalks(arrayOfConsumers);
                    break;
                case("5"):
                    System.out.println("Input range(full numbers) :");
                    System.out.println("Min");
                    String min = phoneUser();
                    System.out.println("Max");
                    String max = phoneUser();
                    phoneNumberDiap(arrayOfConsumers, min, max);
                    break;
                default: return;
            }
        }
    }
}

