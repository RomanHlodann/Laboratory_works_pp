package Cooperation;

import Main.Check;
import Menu.FilterTariffs.FilterTariffs;
import Menu.FilterTariffs.SortingComparatorASC;
import Menu.FilterTariffs.SortingComparatorDESC;
import Tariff.BaseTariff;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Company implements Serializable{
    String name;
    String keyNumb;
    int countOfUsers = 0;
    ArrayList <BaseTariff> tariffs = new ArrayList <>();
    ArrayList <String> phoneNumbers = new ArrayList<>();
    public static ArrayList <Company> companies = new ArrayList <>();
    public Company(String name, String keyNumb){
        this.name = name;
        this.keyNumb = keyNumb;
        companies.add(this);
    }
    public enum TariffSorting{
        ASC, DESC;
    }
    public static ArrayList<BaseTariff> sortTariffs(ArrayList<BaseTariff> tariffs, TariffSorting type){
        ArrayList<BaseTariff> sortedTariffs = new ArrayList<BaseTariff>(tariffs);
        if(type == TariffSorting.ASC)
            Collections.sort(sortedTariffs, new SortingComparatorASC());
        else
            Collections.sort(sortedTariffs, new SortingComparatorDESC());
        return sortedTariffs;
    }
    static Scanner in = new Scanner(System.in);
    public static void addCompany(){
        new Company(inputCompanyName(), Company.inputIdentifier());
    }
    public static void removeCompany(Company company){
        companies.remove(company);
    }
    public void removeTariff(){
        if(tariffs.size() == 0){
            System.out.println("No tariffs were added");
            return;
        }
        try {
            BaseTariff tariff = findTariffForClient();
            tariffs.remove(tariff);
        } catch (RuntimeException e){
            System.out.println("No tariff were found with this filter");
            System.out.println("Do you still wanna remove tariff?");
            if(!Check.askForGetBack())
                return;
        }
    }
    public void addTariffToList(BaseTariff tariff){
        tariffs.add(tariff);
    }
    public static Company findCompany(){
        System.out.println("\nWhich company would you use?");
        if(companies.size() == 0)
            throw new NullPointerException();
        printCompanies();
        return Company.companies.get(Check.inputIntegerWithLimit(companies.size(),"Answer: ") - 1);
    }
    public static Company findCompanyForUser(){
        System.out.println("Which company would you use?");
        ArrayList <Company> availbleCompanies = new ArrayList<>();
        int count = 0;
        for ( Company i : Company.companies){
            if( i.getTariffs().size() == 0)
                continue;
            System.out.println((count+1) + ". " + Company.companies.get(count));
            availbleCompanies.add(Company.companies.get(count));
            count++;
        }
        return Company.companies.get(Check.inputIntegerWithLimit(count+1,"Answer: ") - 1);
    }
    public BaseTariff findTariffForClient() {
        System.out.println("Would you like to use filter? (Y/N)");
        if(Check.askForGetBack()){
            FilterTariffs filterTariffs = new FilterTariffs(this);
            filterTariffs.workMenu();
            if(filterTariffs.getTariffs().size() == 0){
                System.out.println("No tariffs were found :(");
                throw new RuntimeException();
            }
            printTariffs(filterTariffs.getTariffs());
            System.out.println("Which tariff you wanna take?");
            return tariffs.get(Check.inputIntegerWithLimit(filterTariffs.getTariffs().size(), "Answer: ") - 1);
        }
        System.out.println("Which tariff you wanna take?");
        printTariffs(tariffs);
        return tariffs.get(Check.inputIntegerWithLimit(tariffs.size(), "Answer: ") - 1);
    }
    public boolean checkForPhoneInCompany(String phoneNumber){
        for (BaseTariff i : tariffs ){
            if (i.getUsers().contains(phoneNumber))
                return true;
        }
        return false;
    }
    public static String inputCompanyName() {
        while (true){
            Scanner in = new Scanner(System.in);
            System.out.print("\nInput company name: ");
            String str = in.nextLine();
            if(Check.checkCompanyName(str)){
                if(!checkForAvailbleName(str)) {
                    System.out.println("Company already exists!");
                    continue;
                }
                return str;
            }
            System.out.println("Inputed incorrectly! Try again!");
        }
    }
    public static String inputIdentifier(){
        while (true){
            Scanner in = new Scanner(System.in);
            System.out.print("\nInput company identifier: ");
            String str = in.nextLine();
            try{
                if(Check.checkIdentifier(str) == false) {
                    System.out.println("Inputed incorrectly! Try again!");
                    continue;
                }
                Company.searchCompanyByIdentifier(str);
                System.out.println("Identifier already exists!");
            }
            catch(NullPointerException e){
                return str;
            }
        }
    }
    public static boolean checkIsThereAvailbleCompaniesAndTariffs(){
        if(Company.companies.size() == 0){
            return false;
        }
        for ( Company i : Company.companies){
            if ( i.getTariffs().size() != 0 )
                return true;
        }
        return false;
    }
    public static Company searchCompanyByIdentifier(String numb) {
        for(Company i : companies){
            if( i.keyNumb.equals(numb))
                return i;
        }
        throw new NullPointerException();
    }
    public User findUserByPhoneNumber(String str) {
        for(BaseTariff i : tariffs){
            for(User y : i.getUsers()){
                if(y.telephoneNumber.equals(str))
                    return y;
            }
        }
        throw new RuntimeException();
    }
    public boolean deleteUserFromTariff(User user) {
        for(BaseTariff i : tariffs){
            if(i.getUsers().contains(user)) {
                i.getUsers().remove(user);
                return true;
            }
        }
        throw new NullPointerException();
    }
    public static boolean checkForAvailbleName(String name){
        for(Company i: companies){
            if(name.equals(i.getName()))
                return false;
        }
        return true;
    }
    public static void printCompanies(){
        int count = 1;
        for ( Company i: companies){
            System.out.println( count + ". " + i + "\n");
            count++;
        }
    }
    public static void printTariffs(ArrayList<BaseTariff> tariffs){
        if(tariffs.size() == 0){
            System.out.println("No tariifs were found :(");
            return;
        }
        int count = 1;
        for ( BaseTariff i: tariffs){
            System.out.println( count + ". " + i + "\n");
            count++;
        }
    }
    public static ArrayList<Company> getCompanies() {
        return companies;
    }

    public ArrayList<BaseTariff> getTariffs(){
        return tariffs;
    }

    public String getKeyNumb() {
        return keyNumb;
    }

    public String getName() {
        return name;
    }

    public int getCountOfUsers() {
        return countOfUsers;
    }

    public Company updateCountOfUsers(){
        this.countOfUsers += 1;
        return this;
    }

    public void setTariffs(ArrayList<BaseTariff> tariffs) {
        this.tariffs = tariffs;
    }

    public void addNewUserNumber(String phoneNumber){
        phoneNumbers.add(phoneNumber);
    }

    @Override
    public String toString() {
        return "Company name='" + name + '\'' +
                ", identifier =" + keyNumb +
                ", tariffs =" + tariffs +
                ", users =" + countOfUsers;
    }
}