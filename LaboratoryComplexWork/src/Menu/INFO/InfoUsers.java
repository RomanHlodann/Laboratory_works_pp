package Menu.INFO;

import Cooperation.Company;
import Menu.MainMenu.MenuItem;

import java.awt.*;

public class InfoUsers implements MenuItem {
    @Override
    public void execute() {
        if(!Company.checkIsThereAvailbleCompaniesAndTariffs()){
            System.out.println("No companies or tariffs were found:(");
            return;
        }
        try {
            Company company = Company.findCompany();
            if(company.getTariffs().size() == 0) {
                System.out.println("No tariffs in company");
                return;
            }
            company.findTariffForClient().printUsers();
        } catch (RuntimeException e){
            System.out.println("No tariff was found with this filter");
        }
    }
}
