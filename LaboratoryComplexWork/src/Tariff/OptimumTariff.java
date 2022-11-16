package Tariff;

import Main.Check;
import Tariff.BaseTariff;

public class OptimumTariff extends BaseTariff {
    OptimumTariff(int gbOfInternet, int minutesAbroad, String limitTopApps, double price, String timeAction){
        this.name = "Optimum tariff";
        this.gbOfInternet = gbOfInternet;
        this.minutesWithOtherNetwork = 100;
        this.minutesAbroad = minutesAbroad;
        this.limitTopApps = limitTopApps;
        this.countOfSms = 200;
        this.price = price;
        this.timeAction = timeAction;
    }
    public static OptimumTariff addOptimumTariff(){
        return new OptimumTariff(Check.inputIntegerWithLimit(1300, "Input amount of gb (max - 1300):"),
                Check.inputIntegerWithLimit(800, "Input amount of minutes abroad (max - 100):"),
                BaseTariff.isTariffHasUnlimitedTopApps(),BaseTariff.inputPrice(), inputTimeAction());
    }
    public static void printInfo(){
        System.out.println("\n2. Tariff name - Optimum Tariff\n" +
                "Constant parts:\n" +
                "Minutes with other networks: 100\n" +
                "Duration time: 3 month\n" +
                "SMS: 200\n");
    }
}
