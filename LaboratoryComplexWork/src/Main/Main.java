package Main;
import Cooperation.Company;
import Menu.MainMenu.*;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            try {
                System.out.println("Do you wanna add parameters from file? (Y/N)");
                if(!Check.askForGetBack())
                    break;
                getFromFile();
                System.out.println("Successfully added");
                break;
            }catch (NullPointerException e){
                continue;
            }
        }
        MainMenu mainMenu = new MainMenu();
        mainMenu.workMenu();
    }
    public static void writeToFile() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Input file:");
            String file = in.nextLine();
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            for (Company i : Company.getCompanies())
                o.writeObject(i);
            o.close();
            f.close();
            System.out.println("Successfully added");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new NullPointerException();
        } catch (IOException em) {
            System.out.println("Error initializing stream");
            em.printStackTrace();
            throw new NullPointerException();
        }
    }
    public static void getFromFile(){
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Input file:");
            String file = in.nextLine();
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            while(true){
                Company.getCompanies().add((Company)oi.readObject());
            }
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new NullPointerException();
        } catch (EOFException e) {
            return;
        } catch (IOException ex) {
            System.out.println("Error initializing stream");
            throw new NullPointerException();
        } catch (ClassNotFoundException e){}
    }
}
