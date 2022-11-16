package Tariff;

import java.util.ArrayList;
import Cooperation.User;
import Main.Check;

public class AnnualTariff extends BaseTariff {
    AnnualTariff(int gbOfInternet,int minutesAbroad, double price){
        this.name = "Annual Tariff";
        this.gbOfInternet = gbOfInternet;
        this.minutesWithOtherNetwork = 300;
        this.minutesAbroad = minutesAbroad;
        this.limitTopApps = "unlimited";
        this.countOfSms = 300;
        this.price = price;
        this.timeAction = "1 year";
    }
    public static AnnualTariff addAnnualTariff(){
        return new AnnualTariff(Check.inputIntegerWithLimit(1500, "Input amount of gb (max - 1500):"),
                Check.inputIntegerWithLimit(150, "Input amount of minutes abroad (max - 150):"),
                BaseTariff.inputPrice());
    }
    public static void printInfo(){
        System.out.println("\n4. Tariff name - Annual Tariff\n" +
                "Constant parts:\n" +
                "Minutes with other networks: 300\n" +
                "Duration time: 1 year\n" +
                "SMS: 300\n");
    }
}
