import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Household {
    private String id;
    private String street;
    private String state;
    private String city;
    private Boolean DEBUG;

    //this will hold all the members of a particular household
    private HashMap<String, HouseholdMember> members = new HashMap<>();

    //making a hashmap to hold objects(value) by their id(key)
    private static HashMap<String, Household> households = new HashMap<String, Household>();

    /**
     * Constructor for Households
     * @param street Street address of the household
     * @param city  city of the household
     * @param state state of the household
     * @param id unique id for locating later
     * @param DEBUG whether debug information should be displayed or not.
     */
    public Household(String street, String city, String state, String id, Boolean DEBUG){
        this.street = street;
        this.city = city;
        this.state = state;
        this.id = id;
        this.DEBUG = DEBUG;

        households.put(id, this); //add this household to the hashmap holding all Household obj.

        if(DEBUG){
            System.out.println("*DEBUG* Creating new household: " + id);
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getId(){
        return this.id;
    }

    /**
     * This will both create a new HouseholdMember and then add it to this household.
     * @param firstName first name of household member
     * @param lastName last name of household member
     * @param age age of household member
     * @param id unique id for household member
     */
    public void addMember(String firstName, String lastName, int age, String id ) {

        if(this.DEBUG){
            System.out.println("*DEBUG* Attempting to add new member..");
        }

        HouseholdMember memberObj = new HouseholdMember(this, firstName, lastName, age, id, DEBUG);
        this.members.put(id, memberObj);

    }

    public HashMap<String, HouseholdMember> getMembers(){
        return this.members;
    }

    public static HashMap<String, Household> getHouseholds(){
        return households;
    }

    public String getAddress(){
        String address = this.street + ", " + this.city + " " + this.state;
        return address;
    }
    public String getInfo(){
        String address = this.getAddress() + " --- Household Size: " + this.getMembers().size();
        return address;
    }

    public static void clearHouseholds(){
        for(Map.Entry<String, Household> entry : households.entrySet()) {
            String key = entry.getKey();
//            Household value = entry.getValue();
//            households.get(key).getMembers();
            clearHouseholdMembers(households.get(key));
        }
        households.clear();
    }

    private static void clearHouseholdMembers(Household household){
        household.members.clear();
    }
}
