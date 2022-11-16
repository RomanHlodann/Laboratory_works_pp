package Menu.UserMenu;

import Cooperation.User;
import Menu.MainMenu.MenuItem;

public class RemoveUser implements MenuItem {
    public void execute(){
        try {
            String phoneNumb = User.inputFullPhoneNumber();
            User.deleteUserFromTariff(phoneNumb);
            System.out.println("Successfully deleted!");
        } catch (NullPointerException ex){
            return;
        }
        catch (RuntimeException e){
            return;
        }
    }
}
