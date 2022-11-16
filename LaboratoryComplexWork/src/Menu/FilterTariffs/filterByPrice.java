package Menu.FilterTariffs;

import Menu.MainMenu.MenuItem;
import Tariff.BaseTariff;

public class filterByPrice implements MenuItem {
    FilterTariffs filter;
    @Override
    public void execute(){
        System.out.println("Minimal");
        double min = BaseTariff.inputPrice();
        System.out.println("Maximal");
        double max = BaseTariff.inputPrice();
        filter.setTariffs(FilterTariffs.filterTariffsByPrice(filter.getTariffs(),min, max));
    }
    filterByPrice(FilterTariffs filter){
        this.filter = filter;
    }
}
