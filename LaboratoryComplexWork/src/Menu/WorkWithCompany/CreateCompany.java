package Menu.WorkWithCompany;

import Cooperation.Company;
import Menu.MainMenu.MenuItem;

public class CreateCompany implements MenuItem {
    @Override
    public void execute(){
        Company.addCompany();
    }
}
