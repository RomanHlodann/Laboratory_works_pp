import java.util.ArrayList;
import java.util.Scanner;

//Task: 6.Визначити, які числа серед перших N чисел Люка є простими.

public class Learn {
    /** Main method
     *  Creates an array of objects, and fill them with parametrs from command line or keyboard
     *  Calling methods, such as {@link numbLuke#findCount()} and {@link numbLuke#getValue()} }
     *
     */
    public static void main(String[] args) {
        System.out.println("\n\tProgram that searching how many prime numbers in first N Luke row\n");
        int limit = 100, num = 0;
        numbLuke[] arr = new numbLuke[limit]; //creating an array of objects
        if (args.length != 0){            //checking if in command line is availble parametrs
            int i = 0;
            while( i < limit ){   //filling objects with some values
                num = Integer.parseInt(args[i].trim());
                if (num > 0) {
                    arr[i] = new numbLuke(Integer.parseInt(args[i].trim()));
                }
                if(num == 0){break;}
                if(num < 0) {continue;}
                i++;
            }
            limit = i;
        }
        else {                             //if command line isn`t availble filling from keyboard
            Scanner in = new Scanner(System.in);
            int i = 0;
            while(i < limit) {
                System.out.print("Enter N first numbers (end with 0):");
                num = in.nextInt();
                if(num < 0){
                    System.out.println("Error! You wrote a wrong number. Try again!");
                    continue;
                }
                if(num == 0){
                    break;
                }
                arr[i] = new numbLuke(num);
                i++;
            }
            limit = i;
        }
        for(int i = 0; i < limit; i++) {            //calling methods from class numbLuke and output the results to console
            System.out.println("In first " + arr[i].getNumb() + " numbers, prime:" + arr[i].findCount());
            System.out.println(arr[i].getNumb() + " numb of Luke numbers: " + arr[i].getValue());
        }
    }
}

    /**
    *   Class, that contains everything about number of Luke ("id"), its value ("value"), finding if the numb
    *   is prime, finding how many prime numbers is in first N numbers ("count").
    */
    class numbLuke {
        private int count, id, value;//initializing required variable, "count" for prime numbers, "numb"-N,
                                          //and "luke" is value of N numb

        static ArrayList<Integer> listOfLukas = new ArrayList();
        static ArrayList<Integer> listOfPrimes = new ArrayList();
        static int prev = 1, curr = 3, last;
        /**
         * Constructor without parameters
         * Asks for entering numb from keyboard in order to work with it in next methods and calling a method
         * {@link #creatingArrayOfLuke()}
         */
        numbLuke() {                      //constructor without parameters
            System.out.print("Enter N first numbers (end with 0):");
            Scanner in = new Scanner(System.in);
            id = in.nextInt();
            creatingArrayOfLuke();
        }

        /**
         * Constructor with parameter that means N numb of Luke
         * Calling a method {@link #creatingArrayOfLuke()}
         */
        numbLuke(int num) {               //constructor with parameter
            id = num;
            creatingArrayOfLuke();
        }

        /**
         * Method that
         * @return an id
         */
        int getNumb(){
            return id;
        }

        /**
         * Method that
         * @return value of id
         */
        int getValue(){
            return value;
        }
        /**
         * Method, that finding if number
         * @param num is prime
         * if statement is true, add it to list of prime numbers
         */
        void findPrime(int num) {          //checking if the numb is prime
            if (num % 2 == 0)             //in order to reduce the number of passes in for
                return;
            for (int i = 3; i < Math.sqrt(num); i += 2) {
                if (num % i == 0)
                    return;
            }
            listOfPrimes.add(num);
            return;
        }

        /**
         * Method that finding how many prime numbers in first N Luke numbers
         */
        int findCount() {
            if (id == 1 || id == 2) {
                count = id;
                return count;
            }
            if (listOfPrimes.get(listOfPrimes.size() - 1) > value) { // if last numb in list is greater
                count = listOfPrimes.size();
                while (listOfPrimes.get(count - 1) > value ) {       // search of the numb that smaller than value
                    count--;
                }
                return count;
            }
            while(last < id){                       // while the id of last numb that entered in method findPrime
                findPrime(listOfLukas.get(last));     // is smaller than curr id, calling a method
                last++;
            }
            count = listOfPrimes.size();
            //last = id - 1;
            return count;
        }

        /**
         * Creating or complementing array of Luke
         */
        void creatingArrayOfLuke(){
            if(listOfLukas.isEmpty()){
                listOfLukas.add(prev);
                listOfLukas.add(curr);
                listOfPrimes.add(prev);
                listOfPrimes.add(curr);
                last = 2;                   // using variable for
            }
            if (listOfLukas.size() < id){
                for(int i = listOfLukas.size(); i < id; i++){
                    value = prev + curr;
                    prev = curr;
                    curr = value;
                    listOfLukas.add(value);
                }
            }
            else {
                value = listOfLukas.get(id - 1);
            }
        }
    }

