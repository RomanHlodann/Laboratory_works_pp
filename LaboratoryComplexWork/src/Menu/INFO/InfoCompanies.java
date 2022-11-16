package Menu.INFO;

import Cooperation.Company;
import Menu.MainMenu.MenuItem;

public class InfoCompanies implements MenuItem {
    public void execute(){
        if(Company.getCompanies().size() == 0){
            System.out.println("No companies were found");
            return;
        }
        Company.printCompanies();
    }
}
