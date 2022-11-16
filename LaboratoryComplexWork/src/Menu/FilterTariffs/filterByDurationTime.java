package Menu.FilterTariffs;

import Menu.MainMenu.MenuItem;
import Tariff.BaseTariff;

public class filterByDurationTime implements MenuItem {
    FilterTariffs filter;
    @Override
    public void execute(){
        System.out.println("Minimal");
        String min = BaseTariff.inputTimeAction();
        System.out.println("Maximal");
        String max = BaseTariff.inputTimeAction();
        filter.setTariffs(FilterTariffs.filterTariffsByDurationTime(filter.getTariffs(),min, max));
    }
    filterByDurationTime(FilterTariffs filter){
        this.filter = filter;
    }
}
