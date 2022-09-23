package Main;

import java.util.regex.Pattern;

/**
 * Class contains methods which checking if value was inputed correctly
 */
public class Check {
    /**
     * Methods that checks if int value was inputed correctly
     * @param numb - int value
     * @return true or false
     */
    public static boolean checkInt(String numb){
        try {
            int value = Integer.parseInt(numb);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    /**
     * Methods that checks if name was inputed correctly
     * @param name - string value
     * @return true or false
     */
    public static boolean checkName(String name){
        String check = "\\p{Upper}(\\p{Lower}+\\s?)";
        return name.matches(check);
    }
    /**
     * Methods that checks if phone number was inputed correctly
     * @param value - string value
     * @return true or false
     */
    public static boolean checkPhoneNumber(String value){
        String check = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
        if(value.matches(check))
            return true;
        return false;
    }
    public static boolean checkNmbInPhoneNumber(String phoneNumber, String numb){
        String temp = phoneNumber.replaceAll("[^0-9]", "");
        if (temp.contains(numb))
            return true;
        return false;
    }
}
