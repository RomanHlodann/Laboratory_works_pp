package Menu.UserMenu;

import Cooperation.User;
import Menu.MainMenu.MenuItem;

public class AddUser implements MenuItem {
    public void execute(){
        User.addUser();
    }
}
