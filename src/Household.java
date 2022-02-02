import java.util.ArrayList;
import java.util.List;

public class Household {
    private String id;
    private String street;
    private String state;
    private String city;
    private ArrayList<Members> members = new ArrayList<Members>();

    private static List instances = new ArrayList();



    public Household(String street, String city, String state){
        this.street = street;
        this.city = city;
        this.state = state;
        this.id = street + city+ state;

        instances.add(new java.lang.ref.WeakReference(this));
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

    public ArrayList<Members> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Members> members) {
        this.members = members;
    }

    public static List getInstances() {
        return instances;
    }
}
