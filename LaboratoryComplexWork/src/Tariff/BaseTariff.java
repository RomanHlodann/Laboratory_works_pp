package Tariff;

import Cooperation.Company;
import Cooperation.User;
import Main.Check;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseTariff implements Serializable {
    String name;
    int gbOfInternet = 0;
    int minutesWithOtherNetwork = 0;
    int minutesAbroad = 0;
    String limitTopApps;
    int countOfSms = 0;
    double price = 0;
    String timeAction;
    ArrayList<User> users = new ArrayList();
    static Scanner ing = new Scanner(System.in);

    public void addNewUser(User user) {
        users.add(user);
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public static void printInfoAboutTariffs() {
        StartTariff.printInfo();
        OptimumTariff.printInfo();
        MaximumTariff.printInfo();
        AnnualTariff.printInfo();
    }
    public static double inputPrice(){

        while(true){
            System.out.print("Input price of tariff: ");
            String price = ing.nextLine();
            if(Check.checkDouble(price, 1500))
                return Double.parseDouble(price);
        }
    }
    public static String inputTimeAction(){
        while(true) {
            System.out.println("Input tariff duration in format (1 day or 1 month or 1 year)");
            String str = ing.nextLine();
            if(Check.checkTimeDuration(str))
                return str.replaceAll("[^0-9]", "") + " " + str.replaceAll("[0-9 ]", "");;
        }
    }
    public static String isTariffHasUnlimitedTopApps() {
        while(true){
            System.out.print("Does tariff include ulimited access to top apps? (1 - Yes, 2 - No): ");
            String answer = ing.nextLine();
            if(Check.checkInteger(answer, 2))
                return "unlimited";
            return "limited";
        }
    }
    public void printUsers(){
        if(users.size() == 0){
            System.out.println("No users are using this tariff");
        }
        int count = 1;
        for(User i: users){
            System.out.println(count + ". " + i);
        }
    }
    @Override
    public String toString() {
        return   name + '\'' +
                "{amount of gb= " + gbOfInternet +
                ", minutes with other network= " + minutesWithOtherNetwork +
                ", minutes abroad=" + minutesAbroad +
                ",\'" + limitTopApps + '\'' + " access to top apps" +
                ", count of sms= " + countOfSms +
                ", price= " + price +
                ", timeAction= '" + timeAction + '\'' +
                "}\n";
    }

    public String getTimeAction() {
        return timeAction;
    }
    public double getPrice() {
        return price;
    }
}
