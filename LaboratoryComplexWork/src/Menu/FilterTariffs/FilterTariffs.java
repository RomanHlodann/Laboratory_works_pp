package Menu.FilterTariffs;

import Cooperation.Company;
import Menu.MainMenu.MainMenu;
import Menu.MainMenu.MenuItem;
import Tariff.BaseTariff;
import java.util.*;

public class FilterTariffs {
    Company company;
    private Map<String, MenuItem> menuItems;
    ArrayList<BaseTariff> tariffs;
    public FilterTariffs(Company company) {
        this.company = company;
        this.tariffs = new ArrayList<BaseTariff>(company.getTariffs());
        menuItems = new LinkedHashMap<>();
        menuItems.put("1",new filterByDurationTime(this));
        menuItems.put("2", new filterByPrice(this));
    }
    public ArrayList<BaseTariff> workMenu(){
        try {
            while (true) {
                execute(MainMenu.inputAnswer(printInfoMenu()));
            }
        }
        catch (NullPointerException e){
            return tariffs;
        }
    }
    public void execute(String command){
        menuItems.get(command).execute();
    }
    public void setTariffs(ArrayList<BaseTariff> tariffs){
        this.tariffs = tariffs;
    }

    public ArrayList<BaseTariff> getTariffs() {
        return tariffs;
    }

    public static int printInfoMenu(){
        System.out.println("\nChoose which filter you want to use?\n" +
                "1.Filter by duration time\n" +
                "2.Filter by price\n" +
                "3.Apply");
        return 3;
    }
    public static ArrayList<BaseTariff> filterTariffsByDurationTime (ArrayList<BaseTariff>tariffs,String firstLimit, String secondLimit){
        Iterator<BaseTariff> iter = tariffs.iterator();
        int lowerLimit = parseDurations(firstLimit);
        int higherLimit = parseDurations(secondLimit);
        while(iter.hasNext()){
            BaseTariff i = iter.next();
            int duration = parseDurations(i.getTimeAction());
            if(duration > lowerLimit)
                if(duration < higherLimit)
                    continue;
            iter.remove();
        }
        return tariffs;
    }
    public static ArrayList<BaseTariff> filterTariffsByPrice(ArrayList<BaseTariff>tariffs,double firstLimit, double secondLimit){
        tariffs.removeIf(i -> i.getPrice() < firstLimit || i.getPrice() > secondLimit);
        return tariffs;
    }
    public static int parseDurations(String timeDurat){
        String unitOfTime = timeDurat.replaceAll("[0-9 ]", "");
        if(unitOfTime.equals("month"))
            return Integer.parseInt(timeDurat.replaceAll("[^0-9]", "")) * 30;
        if(unitOfTime.equals("year"))
            return Integer.parseInt(timeDurat.replaceAll("[^0-9]", "")) * 30 * 12;
        return Integer.parseInt(timeDurat.replaceAll("[^0-9]", ""));
    }
}
