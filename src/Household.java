import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;

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
     *
     * @param street The street address of the household
     * @param city the city the household resides in
     * @param state the state the household resides in.
     *
     * @// TODO: 2/1/2022 add validation and input cleaning to id
     *      (Street should be st, st should be st.) etc
     */

    public Household(String street, String city, String state, String id, Boolean DEBUG){
        this.street = street;
        this.city = city;
        this.state = state;
        this.id = id;

//        instances.add(id);
        households.put(id, this);

        if(DEBUG){
            this.DEBUG = true;
            System.out.println("Creating new household: " + id);
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

    public void addMember(String firstName, String lastName, int age, String id ) {
        HouseholdMember memberObj = new HouseholdMember(this, firstName, lastName, age, id);
        this.members.put(id, memberObj);

        if(this.DEBUG){
            System.out.println("Adding Household member: " + lastName + ", " + firstName + ". To household: " + this.id);
        }
    }

    public HashMap<String, HouseholdMember> getMembers(){
        return this.members;
    }

    public static HashMap<String, Household> getHouseholds(){
        return households;
    }




}
