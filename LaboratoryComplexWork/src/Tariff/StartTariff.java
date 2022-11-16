package Tariff;

import Main.Check;
import Tariff.BaseTariff;

public class StartTariff extends BaseTariff {
    StartTariff( int minutesWithOtherNetwork, int countOfSms, double price) {
        this.name = "Start tariff";
        this.gbOfInternet = 50;
        this.minutesWithOtherNetwork = minutesWithOtherNetwork;
        this.minutesAbroad = 0;
        this.limitTopApps = "limited";
        this.countOfSms = countOfSms;
        this.price = price;
        this.timeAction = "14 day";
    }
    public static StartTariff addStartTariff(){
        return new StartTariff(Check.inputIntegerWithLimit(500, "Input amount of minutes with other networks (max - 500):"),
                Check.inputIntegerWithLimit(500, "Input amount of SMS (max - 500):"), BaseTariff.inputPrice());
    }
    public static void printInfo(){
        System.out.println("\n1. Tariff name - Start Tariff\n" +
                "GB of Internet: 50\n" +
                "Constant parts:\n" +
                "Minutes abroad: 0\n" +
                "limited access to top apps\n" +
                "Duration time: 1 month\n");
    }
}
