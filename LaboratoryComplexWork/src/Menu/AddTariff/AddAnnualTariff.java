package Menu.AddTariff;

import Menu.WorkWithCompany.ExistingCompany.WorkWithExistingCompany;
import Tariff.AnnualTariff;
import Menu.MainMenu.MenuItem;

public class AddAnnualTariff implements MenuItem{
    @Override
    public void execute(){
        WorkWithExistingCompany.gettCompany().addTariffToList(AnnualTariff.addAnnualTariff());
    }
}
