package Menu.INFO;

import Cooperation.Company;
import Menu.MainMenu.MenuItem;

public class InfoTariffs implements MenuItem {
    public void execute(){
        if(!Company.checkIsThereAvailbleCompaniesAndTariffs()){
            System.out.println("No availble companies or tariffs were found :(");
            return;
        }
        try {
            Company.printTariffs(Company.findCompany().getTariffs());
        } catch (NullPointerException e){
            return;
        }
    }
}
