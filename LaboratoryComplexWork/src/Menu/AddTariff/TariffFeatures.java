package Menu.AddTariff;

import Menu.MainMenu.MenuItem;
import Tariff.BaseTariff;

public class TariffFeatures implements MenuItem {
    public void execute(){
        BaseTariff.printInfoAboutTariffs();
    }
}
