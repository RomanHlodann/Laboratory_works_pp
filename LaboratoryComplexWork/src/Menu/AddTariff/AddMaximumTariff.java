package Menu.AddTariff;

import Menu.WorkWithCompany.ExistingCompany.WorkWithExistingCompany;
import Tariff.MaximumTariff;
import Menu.MainMenu.MenuItem;


public class AddMaximumTariff implements MenuItem{
    @Override
    public void execute(){
        WorkWithExistingCompany.gettCompany().addTariffToList(MaximumTariff.addMaximumTariff());
    }
}
