package Menu.WorkWithCompany.ExistingCompany;

import Cooperation.Company;
import Main.Check;
import Menu.AddTariff.*;
import Menu.MainMenu.MainMenu;
import Menu.MainMenu.MenuItem;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WorkWithExistingCompany implements MenuItem {
    static Company company;
    private Map<String, MenuItem> menuCompanyItems;
    @Override
    public void execute(){
        try {
            company = Company.findCompany();
        }catch (NullPointerException e){
            System.out.println("No companies were found. Add some!");
            return;
        }
        workMenu();
    }
    public WorkWithExistingCompany(){
        menuCompanyItems = new LinkedHashMap<>();
        menuCompanyItems.put("1", new TariffMenu());
        menuCompanyItems.put("2", new RemoveTariff());
        menuCompanyItems.put("3", new SortTariffsASC());
        menuCompanyItems.put("4", new SortTariffsDESC());
        menuCompanyItems.put("5", new CountOfUsers());
        menuCompanyItems.put("6", new RemoveCompany());
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
        menuCompanyItems.get(command).execute();
    }
    public static Company gettCompany(){
        return company;
    }
    public static int printInfoMenu(){
        System.out.println("\nChoose what you want to do?\n" +
                "1.Add tariff\n" +
                "2.Remove tariff\n" +
                "3.Sort Tariffs ASC\n" +
                "4.Sort Tariffs DESC\n" +
                "5.Get count of users\n" +
                "6.Remove company\n" +
                "7.Get back\n");
        return 7;
    }
}
