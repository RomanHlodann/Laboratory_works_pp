package Tariff;

import Main.Check;
import Tariff.BaseTariff;

public class MaximumTariff extends BaseTariff {
    MaximumTariff(int gbOfInternet,int minutesWithOtherNetwork, double price, String timeAction){
        this.name = "Maximum Tariff";
        this.gbOfInternet = gbOfInternet;
        this.minutesWithOtherNetwork = minutesWithOtherNetwork;
        this.minutesAbroad = 150;
        this.limitTopApps = "unlimited";
        this.countOfSms = 500;
        this.price = price;
        this.timeAction = timeAction;
    }
    public static MaximumTariff addMaximumTariff(){
        return new MaximumTariff(Check.inputIntegerWithLimit(1500, "Input amount of gb (max - 1500):"),
                Check.inputIntegerWithLimit(1000, "Input amount of minutes with other networks (max - 1000):"),
                BaseTariff.inputPrice(), inputTimeAction());
    }
    public static void printInfo(){
        System.out.println("\n3. Tariff name - Maximum Tariff\n" +
                "Constant parts:\n" +
                "Minutes abroad: 150\n" +
                "Unlimited access to top apps\n" +
                "SMS: 500\n");
    }
}
