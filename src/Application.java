import java.io.FileNotFoundException;  // error handling
import java.io.InputStream;


public class Application {
    public static void main(String[] args) {
        ConsoleGUI console = new ConsoleGUI();
        console.init();

        GUI myGui = new GUI();
        myGui.startGUI();
    }

    public static void firstRuntime(String howToSort, Boolean DEBUG) throws FileNotFoundException {
        InputStream inputStream = Application.class.getResourceAsStream("INPUT.txt");
        FileHandler input = new FileHandler(inputStream, DEBUG);
        input.readFile();
        input.writeHouseholds();

        SortHouseholds sorter = new SortHouseholds() {};
        if(howToSort.equals("sortByMembers")){
            sorter.sortAllMembers(true, 18, DEBUG);
        } else {
            sorter.sortAllMembersByHousehold(18, DEBUG);
        }
    }

    public static void repeatRuntime(){
        //clear objects for another go!
        HouseholdMember.clearMembers();
        System.out.println("\n\n\n-------- Clearing Members for another run! --------");
        Household.clearHouseholds();
        System.out.println("-------- Clearing Households for another run! --------\n\n\n");
        //restart gui
        GUI myGui = new GUI();
        myGui.startGUI();
    }
}
