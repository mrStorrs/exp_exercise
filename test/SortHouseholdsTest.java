import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SortHouseholdsTest {

    @Test
    void sortHouseholds() {
        FileHandler a = new FileHandler("./input/INPUT.txt", true);
        a.readFile();
        a.writeHouseholds();

        SortHouseholds sorter = new SortHouseholds() {};
        sorter.sortHouseholds(Household.getHouseholds(), true);
    }

    @Test
    void sortMembersByHousehold() {
        FileHandler a = new FileHandler("./input/INPUT.txt", true);
        a.readFile();
        a.writeHouseholds();

        SortHouseholds sorter = new SortHouseholds() {};
        List<String> sortedHouseholds = new ArrayList<String>();
        sortedHouseholds = sorter.sortHouseholds(Household.getHouseholds(), true);
        sorter.sortOver18MembersByHousehold(sortedHouseholds, true);
    }
}