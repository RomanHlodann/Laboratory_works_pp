package Menu.WorkWithCompany.ExistingCompany;

import Menu.MainMenu.MenuItem;

public class CountOfUsers implements MenuItem {
    public void execute(){
        System.out.println("Amout of users in this company: " +
                WorkWithExistingCompany.gettCompany().getCountOfUsers());
    }
}
