package Menu.AddTariff;

import Cooperation.Company;
import Main.Check;
import Menu.MainMenu.MainMenu;
import Menu.MainMenu.MenuItem;
import Tariff.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TariffMenu implements MenuItem{
    private Map<String, MenuItem> menuItems;
    Company company;
    @Override
    public void execute(){
        workMenu();
    }
    public TariffMenu(){
        menuItems = new LinkedHashMap<>();
        menuItems.put("1", new AddStartTariff());
        menuItems.put("2", new AddOptimumTariff());
        menuItems.put("3", new AddMaximumTariff());
        menuItems.put("4", new AddAnnualTariff());
        menuItems.put("5", new TariffFeatures());
    }
    public void workMenu(){
        try {
            while (true) {
                execute(MainMenu.inputAnswer(printInfoMenu()));
            }
        }
        catch (NullPointerException e){
            return;
        }
    }
    public void execute(String command){
        menuItems.get(command).execute();
    }
    public static int printInfoMenu(){
        System.out.println("\nChoose tariff you want to create? \n" +
                "1.Start Tariff.\n" +
                "2.Optimum Tariff\n" +
                "3.Maximum Tariff\n" +
                "4.Annual Tariff\n" +
                "5.Check all features of these tariffs\n" +
                "6.Get back");
        return 6;
    }
}
