import org.junit.jupiter.api.Test;

class SortHouseholdsTest {

    @Test
    void sortByHousehold() {
        FileHandler a = new FileHandler("./input/INPUT.txt", true);
        a.readFile();
        a.writeHouseholds();

        SortHouseholds sorter = new SortHouseholds() {};
        sorter.sortHouseholds(Household.getHouseholds(), true);
    }
}