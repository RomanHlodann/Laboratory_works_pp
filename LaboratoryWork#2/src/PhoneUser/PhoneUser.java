package PhoneUser;

/**
 * Class that contains everything about phone user
 */
public class PhoneUser {
    private String surname, name, middleName, number;
    private int id, timeOfCity, timeOfCountry;

    /**
     *  Constructor with paramaters
     */
    public PhoneUser(int id, String surname, String name, String middleName,String number, int timeOfCity, int timeOfCountry){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.number = number;
        this.timeOfCity = timeOfCity;
        this.timeOfCountry = timeOfCountry;
    }
    public String toString() {
        return "\nID:" + id +"\nName: " + name + "\nSurname: " + surname
                + "\nMiddle name: " + middleName + "\nPhone number: " + number
                + "\nTime of city talks: " + timeOfCity + "\nTime of country talks: " + timeOfCountry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setTimeOfCity(int timeOfCity){
        this.timeOfCity = timeOfCity;
    }

    public void setTimeOfCountry(int timeOfCountry){
        this.timeOfCountry = timeOfCountry;
    }

    public int getTimeOfCity(){
        return timeOfCity;
    }

    public int getTimeOfCountry(){
        return timeOfCountry;
    }
}
