package Menu.WorkWithCompany.ExistingCompany;

import Menu.MainMenu.MenuItem;
import Tariff.BaseTariff;

import java.util.ArrayList;

public class RemoveTariff implements MenuItem {
    public void execute(){
        WorkWithExistingCompany.gettCompany().removeTariff();
    }
}
