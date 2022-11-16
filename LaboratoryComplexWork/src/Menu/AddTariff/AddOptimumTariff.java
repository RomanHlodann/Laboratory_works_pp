package Menu.AddTariff;

import Menu.MainMenu.MenuItem;
import Menu.WorkWithCompany.ExistingCompany.WorkWithExistingCompany;
import Tariff.OptimumTariff;

public class AddOptimumTariff implements MenuItem{
    @Override
    public void execute(){
        WorkWithExistingCompany.gettCompany().addTariffToList(OptimumTariff.addOptimumTariff());
    }
}
