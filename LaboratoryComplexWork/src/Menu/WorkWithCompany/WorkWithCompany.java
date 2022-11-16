package Menu.WorkWithCompany;

import Main.Check;
import Menu.MainMenu.MenuItem;
import Menu.WorkWithCompany.ExistingCompany.WorkWithExistingCompany;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WorkWithCompany implements MenuItem{
    @Override
    public void execute(){
        inputAnswer();
    }
    private Map<String, MenuItem> menuItems;
    public WorkWithCompany(){
        menuItems = new LinkedHashMap<>();
        menuItems.put("1", new CreateCompany());
        menuItems.put("2", new WorkWithExistingCompany());
    }
    public void inputAnswer(){
        while(true){
            Scanner in = new Scanner(System.in);
            int countOfPosition = printInfoMenu();
            String ans = (Integer.toString(Check.inputIntegerWithLimit(countOfPosition, "Your choice: ")));
            if(ans.equals("3"))
                return;
            execute(ans);
        }
    }
    public void execute(String command){
        menuItems.get(command).execute();
    }
    public static int printInfoMenu(){
        System.out.println("\nChoose what you want to do?\n" +
                "1.Create company\n" +
                "2.Work with existing company\n" +
                "3.Get back");
        return 3;
    }
}
