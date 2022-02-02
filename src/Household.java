import java.lang.reflect.Member;
import java.util.ArrayList;

public class Household {
    private String id;
    private String street;
    private String state;
    private String city;
    private Boolean DEBUG;
    private ArrayList<Member> members = new ArrayList<Member>();

    //this will hold the id of all instances of this class.
    private static ArrayList<String> instances = new ArrayList();


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

        if(DEBUG){
            this.DEBUG = true;
//            System.out.println("Adding new household: " + street + ", " + city + ", " + state);
//            System.out.println(instances.toString());
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

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public static ArrayList<String> getInstances() {
        return instances;
    }
}
