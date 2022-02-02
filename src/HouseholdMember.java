import java.util.HashMap;

public class HouseholdMember {
    private Household household;
    private String firstName;
    private String lastName;
    private int age;
    private String id;

    //making a hashmap to hold objects(value) by their id(key)
    private static HashMap<String, HouseholdMember> members = new HashMap<String, HouseholdMember>();

    public HouseholdMember(Household household, String firstName, String lastName, int age, String id, Boolean DEBUG) {
        //check if member exists
        try{
            if (members.containsKey(id)){
                throw new IllegalArgumentException("Sorry, the member you are trying to add already belongs to this household.");
            } else {
                this.household = household;
                this.firstName = firstName;
                this.lastName = lastName;
                this.age = age;
                this.id  = id;
                members.put(id, this);

                if(DEBUG){
                    System.out.println("Adding Member: " + lastName + ", " + firstName + " to " + this.household.getId());
                }
            }
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
