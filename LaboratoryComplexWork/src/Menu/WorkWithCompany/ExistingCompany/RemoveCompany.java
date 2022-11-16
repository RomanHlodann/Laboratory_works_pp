package Menu.WorkWithCompany.ExistingCompany;


import Cooperation.Company;
import Menu.MainMenu.MenuItem;

public class RemoveCompany implements MenuItem {
    public void execute(){
        Company.removeCompany(WorkWithExistingCompany.gettCompany());
        System.out.println("Company was successfully deleted! New list of companies");
        Company.printCompanies();
        throw new NullPointerException();
    }
}
