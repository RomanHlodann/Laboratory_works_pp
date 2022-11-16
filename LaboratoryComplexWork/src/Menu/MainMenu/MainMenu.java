package Menu.MainMenu;


import Cooperation.Company;
import Cooperation.User;
import Main.Check;
import Menu.AddTariff.*;
import Menu.INFO.InfoMenu;
import Menu.UserMenu.UserMenu;
import Menu.WorkWithCompany.WorkWithCompany;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    private Map<String, MenuItem> menuItems;
    public MainMenu(){
        menuItems = new LinkedHashMap<>();
        menuItems.put("1", new WorkWithCompany());
        menuItems.put("2", new UserMenu());
        menuItems.put("3", new LoadData());
        menuItems.put("4", new InfoMenu());
        menuItems.put("5", new ExitMenu());
    }
    public void execute(String command){
        menuItems.get(command).execute();
    }
    public void workMenu(){
        try {
            while (true) {
                execute(inputAnswer(printInfoMenu()));
            }
        }
        catch (NullPointerException e){
            return;
        }
    }
    public static String inputAnswer(int countOfPosition) throws NullPointerException{
        String ans = (Integer.toString(Check.inputIntegerWithLimit(countOfPosition, "Your choice: ")));
        if(ans.equals(Integer.toString(countOfPosition)))
            throw new NullPointerException();
        return ans;
    };
    public static int printInfoMenu(){
        System.out.println("\nChoose what you want to do?\n" +
                "1.Work with company\n" +
                "2.Work with user\n" +
                "3.Load data to file\n" +
                "4.INFO\n" +
                "5.Exit");
        return 5;
    }
}
