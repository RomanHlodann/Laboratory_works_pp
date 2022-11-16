package Menu.INFO;

import Cooperation.Company;
import Menu.AddTariff.TariffMenu;
import Menu.MainMenu.MainMenu;
import Menu.MainMenu.MenuItem;
import Menu.WorkWithCompany.ExistingCompany.CountOfUsers;
import Menu.WorkWithCompany.ExistingCompany.RemoveCompany;
import Menu.WorkWithCompany.ExistingCompany.RemoveTariff;

import java.util.LinkedHashMap;
import java.util.Map;

public class InfoMenu implements MenuItem{
    private Map<String, MenuItem> menuInfoItems;
    @Override
    public void execute(){
        workMenu();
    }
    public InfoMenu(){
        menuInfoItems = new LinkedHashMap<>();
        menuInfoItems.put("1", new InfoCompanies());
        menuInfoItems.put("2", new InfoTariffs());
        menuInfoItems.put("3", new InfoUsers());
        menuInfoItems.put("4", new RemoveCompany());
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
        menuInfoItems.get(command).execute();
    }
    public static int printInfoMenu(){
        System.out.println("\nChoose what you want to do?\n" +
                "1.All companies\n" +
                "2.All tariffs in companies\n" +
                "3.All users in tariff\n" +
                "4.Get back\n");
        return 4;
    }
}
