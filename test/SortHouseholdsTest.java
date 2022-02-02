import org.junit.jupiter.api.Test;

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
    void sortAllMembers() {
        FileHandler a = new FileHandler("./input/INPUT.txt", true);
        a.readFile();
        a.writeHouseholds();

        SortHouseholds sorter = new SortHouseholds() {};
        sorter.sortAllMembers(true, 18, true);
    }

    @Test
    void sortAllMembersByHousehold() {
        FileHandler a = new FileHandler("./input/INPUT.txt", true);
        a.readFile();
        a.writeHouseholds();

        SortHouseholds sorter = new SortHouseholds() {};
        sorter.sortAllMembersByHousehold(18, true);
    }
}