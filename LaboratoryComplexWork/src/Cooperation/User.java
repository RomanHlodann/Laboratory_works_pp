package Cooperation;

import Tariff.BaseTariff;
import Main.*;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable{
    String name;
    String surname;
    String telephoneNumber;
    public static Scanner in = new Scanner(System.in);
    public User(String name, String surname, String telephoneNumber){
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
    }
    public static void addUser(){
        if(!Company.checkIsThereAvailbleCompaniesAndTariffs()){
            System.out.println("No availble companies or tariffs were found :(");
            return;
        }
        BaseTariff tariff;
        Company company = Company.findCompanyForUser();
        while(true) {
            try {
                tariff = company.findTariffForClient();
                break;
            } catch (RuntimeException e) {
                System.out.println("Would u like to try again? (Y/N)");
                if (!Check.askForGetBack())
                    return;
            }
        }
        try {
            User user = new User(inputName("client name"), inputName("client surname"), inpPhoneNumber(company.getKeyNumb(), company));
            tariff.addNewUser(user);
            company.updateCountOfUsers().addNewUserNumber(user.telephoneNumber);
        }catch (NullPointerException e){
            return;
        }
    }
    public static void changeTariffForUser(String phoneNumber){
        if(!Company.checkIsThereAvailbleCompaniesAndTariffs()){
            System.out.println("No availble companies or tariffs were found :(");
            return;
        }
        while (true) {
            Company company;
            try {
                company = Company.searchCompanyByIdentifier(phoneNumber.substring(0, 2));
            } catch (NullPointerException e) {
                System.out.println("No company with such identifier were found");
                throw new NullPointerException();
            }
            try {
                User user = company.findUserByPhoneNumber("(+380)" + phoneNumber);
                company.findTariffForClient().addNewUser(user);
                company.deleteUserFromTariff(user);
                break;
            } catch (NullPointerException e) {
                System.out.println("No user were found with this phone number :(");
                throw new NullPointerException();
            } catch (RuntimeException ex) {
                System.out.println("No tariff was found with this filters");
                System.out.println("Would u like to try again? (Y/N)");
                if (!Check.askForGetBack()) {
                    throw new NullPointerException();
                }
            }
        }
    }
    public static User deleteUserFromTariff(String phoneNumb) {
        if (!Company.checkIsThereAvailbleCompaniesAndTariffs()) {
            System.out.println("No availble companies or tariffs were found :(");
            throw new NullPointerException();
        }
        while (true) {
            Company company;
            try {
                company = Company.searchCompanyByIdentifier(phoneNumb.substring(0, 2));
            } catch (NullPointerException e) {
                System.out.println("No company with such identifier were found");
                throw new NullPointerException();
            }
            try {
                User user = company.findUserByPhoneNumber("(+380)" + phoneNumb);
                company.deleteUserFromTariff(user);
                return user;
            } catch (RuntimeException e) {
                System.out.println("No user were found with that number");
                throw new NullPointerException();
            }
        }
    }

    public static String inputFullPhoneNumber(){
        while(true){
            System.out.print("Input users phone number:\n(+380)");
            String str = (in.nextLine()).replaceAll("[- ]", "");
            if(!str.matches("^[0-9]{9}")) {
                System.out.println("Inputed not a telephone number!");
                System.out.print("Do you wannna get back? (Y/N): ");
                if (Check.askForGetBack())
                    throw new NullPointerException();
                continue;
            }
            if(!Check.checkPhoneNumber(str.substring(str.length()-7))){
                System.out.println("Inputed wrong number");
                continue;
            }
            if(!Check.checkIdentifier(str.substring(0, str.length()-7))){
                System.out.println("Wrong inputed company identifier (" + str.substring(0, str.length()-7) + ")");
                continue;
            }
            return str;
        }
    }
    public static String inpPhoneNumber(String ident, Company company){
        String str = "(+380)" + ident;
        while(true){
            System.out.print("Input client phone of telephone (7 numbers)\n" + str);
            String phoneNumber = in.nextLine();
            if(Check.checkPhoneNumber(phoneNumber))
                if(!company.checkForPhoneInCompany(str + phoneNumber.replaceAll("[- ]", "")))
                    return str + phoneNumber.replaceAll("[- ]", "");
                else {
                    System.out.println("This number already exists!");
                    continue;
                }
            System.out.println("Inputed incorrectly! Try again!");
            System.out.print("Do you wannna get back? (Y/N): ");
            if (Check.askForGetBack())
                throw new NullPointerException();
        }
    }
    public static String inputName(String name){
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.print("\nInput " + name + ": ");
            String str = in.nextLine();
            if(Check.checkName(str) == true)
                return str;
            System.out.println("Try again!");
        }
    }
    public String getTelephoneNumber(){
        return telephoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
