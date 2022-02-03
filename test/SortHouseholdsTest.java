import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

class SortHouseholdsTest {
    static InputStream inputStream;
    static FileHandler a;

    @BeforeAll
    public static void setUp(){
        inputStream = Application.class.getResourceAsStream("INPUT.txt");
        a = new FileHandler(inputStream, true);
    }

    /**
     * The following tests must now be run individually until I can properly set them up.!!!
     */
    @Test
    void sortHouseholds() {
        a.readFile();
        a.writeHouseholds();
        SortHouseholds sorter = new SortHouseholds() {};
        sorter.sortHouseholds(Household.getHouseholds(), true);
    }

    @Test
    void sortAllMembers() {
        a.readFile();
        a.writeHouseholds();
        SortHouseholds sorter = new SortHouseholds() {};
        sorter.sortAllMembers(true, 18, true);
    }

    @Test
    void sortAllMembersByHousehold() {
        a.readFile();
        a.writeHouseholds();
        SortHouseholds sorter = new SortHouseholds() {};
        sorter.sortAllMembersByHousehold(18, true);
    }
}