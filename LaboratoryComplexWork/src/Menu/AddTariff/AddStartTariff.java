package Menu.AddTariff;

import Menu.MainMenu.MenuItem;
import Menu.WorkWithCompany.ExistingCompany.WorkWithExistingCompany;
import Tariff.StartTariff;

public class AddStartTariff implements MenuItem {
    @Override
    public void execute(){
        WorkWithExistingCompany.gettCompany().addTariffToList(StartTariff.addStartTariff());
    }
}
