public class HouseholdMember {
    private Household household;
    private String firstName;
    private String lastName;
    private int age;

    public HouseholdMember(Household household, String firstName, String lastName, int age) {
        this.household = household;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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
