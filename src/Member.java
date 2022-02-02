public class Member{
    private Household household;
    private String firstName;
    private String lastName;
    private String age;

    public Member(Household household, String firstName, String lastName, String age) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
