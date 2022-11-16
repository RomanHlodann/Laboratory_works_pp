package Menu.WorkWithCompany.ExistingCompany;

import Cooperation.Company;
import Menu.MainMenu.MenuItem;

public class SortTariffsDESC implements MenuItem {
    public void execute(){
        Company company = WorkWithExistingCompany.gettCompany();
        company.setTariffs(Company.sortTariffs(company.getTariffs(), Company.TariffSorting.DESC));
        System.out.println("New list of tariffs");
        Company.printTariffs(company.getTariffs());
    }
}
