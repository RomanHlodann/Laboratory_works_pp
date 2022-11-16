package Menu.UserMenu;

import Cooperation.Company;
import Cooperation.User;
import Menu.MainMenu.MenuItem;
import Tariff.BaseTariff;

public class ChangeTariffForUser implements MenuItem {
    public void execute(){
        String phoneNumb = User.inputFullPhoneNumber();
        User.changeTariffForUser(phoneNumb);
        System.out.println("Successfully changed");
    }
}
