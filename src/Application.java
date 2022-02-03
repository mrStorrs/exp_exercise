import java.io.FileNotFoundException;  // error handling


public class Application {
    public static void main(String[] args) {
        Boolean DEBUG = false; //whether to output debug info or not.
        ConsoleGUI console = new ConsoleGUI();
        console.init();

        GUI myGui = new GUI();
        myGui.startGUI();
    }

    public static void firstRuntime(String howToSort, Boolean DEBUG) throws FileNotFoundException {

        FileHandler input = new FileHandler("input/INPUT.txt", DEBUG);
        input.readFile();
        input.writeHouseholds();

        SortHouseholds sorter = new SortHouseholds() {};
        if(howToSort == "sortByMembers"){
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
        GUI myGui = new GUI();
        myGui.startGUI();
    }
}
