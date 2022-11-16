package Menu.UserMenu;

import Menu.MainMenu.ExitMenu;
import Menu.MainMenu.MainMenu;
import Menu.MainMenu.MenuItem;
import Menu.WorkWithCompany.ExistingCompany.RemoveTariff;
import Menu.WorkWithCompany.WorkWithCompany;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserMenu implements MenuItem {
    public void execute(){
        workMenu();
    }
    private Map<String, MenuItem> menuUserItems;
    public UserMenu(){
        menuUserItems = new LinkedHashMap<>();
        menuUserItems.put("1", new AddUser());
        menuUserItems.put("2", new ChangeTariffForUser());
        menuUserItems.put("3", new RemoveUser());
    }
    public void execute(String command){
        menuUserItems.get(command).execute();
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
    public static int printInfoMenu(){
        System.out.println("\nChoose what you want to do?\n" +
                "1.Add user\n" +
                "2.ChangeTariff\n" +
                "3.RemoveUser\n" +
                "4.Get back\n");
        return 4;
    }
}
