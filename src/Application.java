import java.io.FileNotFoundException;  // error handling
import java.io.PrintStream; //used to push data to a log file.

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        Boolean DEBUG = false; //whether to output debug info or not.

        PrintStream fileOut = new PrintStream("output/out.txt");
        System.setOut(fileOut);

        FileHandler input = new FileHandler("input/INPUT.txt", DEBUG);
        input.readFile();
        input.writeHouseholds();

        SortHouseholds sorter = new SortHouseholds() {};
//        sorter.sortAllMembers(true, 18, DEBUG);
        sorter.sortAllMembersByHousehold(18, DEBUG);
    }
}
