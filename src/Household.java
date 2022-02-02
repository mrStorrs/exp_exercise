import java.util.ArrayList;
import java.util.HashMap;

public class Household {
    private String id;
    private String street;
    private String state;
    private String city;
    private Boolean DEBUG;
    private ArrayList<HouseholdMember> members = new ArrayList<HouseholdMember>();

    //this will hold the id of all instances of this class.
    private static ArrayList<String> instances = new ArrayList();

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

        instances.add(id);
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

    public ArrayList<HouseholdMember> getPeople() {
        return members;
    }

    public void addMember(String firstName, String lastName, int age ) {
        HouseholdMember memberObj = new HouseholdMember(this, firstName, lastName, age);
        members.add(memberObj);

        if(this.DEBUG){
            System.out.println("Adding Household member: " + lastName + ", " + firstName + ". To household: " + this.id);
        }
    }

    public static HashMap<String, Household> getHouseholds(){
        return households;
    }
    public static ArrayList<String> getInstances() {
        return instances;

    }



}
