import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseholdTest {

    static Household a, b;

    @BeforeAll
    public static void setUp(){
        a = new Household("123 main st.", "seattle", "wa", "0", true);
    }

    @Test
    void setStreet() { //testing for both set/get street
        String exp = "changed";
        a.setStreet(exp);
        assertEquals(exp, a.getStreet());
    }

    @Test
    void setState() {
        String exp = "changed";
        a.setState(exp);
        assertEquals(exp, a.getState());
    }

    @Test
    void setCity() {
        String exp = "changed";
        a.setCity(exp);
        assertEquals(exp, a.getCity());
    }

    @Test
    void getId() {
        assertEquals((a.getStreet() + a.getCity() + a.getState()), a.getId());
    }

    @Test
    void getMembers() {
    }

    @Test
    void setMembers() {
    }

    @Test
    void getInstances() {
    }
}