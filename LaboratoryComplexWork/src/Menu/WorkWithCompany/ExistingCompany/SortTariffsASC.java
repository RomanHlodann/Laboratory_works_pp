package Menu.WorkWithCompany.ExistingCompany;

import Cooperation.Company;
import Menu.MainMenu.MenuItem;
import Tariff.BaseTariff;

import java.util.ArrayList;

public class SortTariffsASC implements MenuItem {
    public void execute(){
        Company company = WorkWithExistingCompany.gettCompany();
        company.setTariffs(Company.sortTariffs(company.getTariffs(), Company.TariffSorting.ASC));
        System.out.println("New list of tariffs");
        Company.printTariffs(company.getTariffs());
    }
}
