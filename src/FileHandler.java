import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileHandler {
    private String path;
    private ArrayList<String> rawInput = new ArrayList<String>();
    private Boolean DEBUG;

    public FileHandler(String path, Boolean DEBUG){
        this.setPath(path);
        this.DEBUG = DEBUG;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    /**
     * Logic for reading the file and then outputting each line item (household)
     * to an array that will hold all items.
     */
    public void readFile(){
        try {
            File input = new File(this.path); //open file
            Scanner reader = new Scanner(input); //ready scanner
            while (reader.hasNextLine()) { //move through file.
                String data = reader.nextLine();
                this.rawInput.add(data); //add the new line to our raw input

                if(DEBUG){
                    System.out.println("*DEBUG* Adding raw-data: " + data);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("*ERROR* The file specified cannot be found.");
            e.printStackTrace();
        }
    }

    public ArrayList<String> getRawInput(){
        return this.rawInput;
    }

    /**
     * Logic for dealing with data that has been read. This will determine whether new Households
     * need to be created and where to add new members to said households.
     */
    public void writeHouseholds(){
        //pull the current hashmap holding all households.
        HashMap<String, Household> households = Household.getHouseholds();

        //loop through the raw data and decide what to do with each line.
        for(String household : this.rawInput){
            List<String> householdArr = new ArrayList<>();
            //split information by beginning and end quotes
            int first_pos = -1;
            for(int i = 0; i < household.length(); i++) {
                if (household.charAt(i) == '\"' && first_pos < 0) { //first pos not set. set it.
                    first_pos = i;
                } else if (household.charAt(i) == '\"') { //found first pos. must be second quote. split here.
                    householdArr.add(household.substring(first_pos + 1, i));
                    first_pos = -1; //looking for first quote again.
                }
            }

            //set ids for construction of new household &| member
            String first = householdArr.get(0);
            String last = householdArr.get(1);
            String street = householdArr.get(2);
            String city = householdArr.get(3);
            String state = householdArr.get(4);
            int age = Integer.parseInt(householdArr.get(5));

            //creating id for household.
            String householdID =
                    state.replaceAll("\\p{Punct}", "").toLowerCase()
                    + city.replaceAll("\\p{Punct}", "").toLowerCase()
                    + street.replaceAll("\\W", "").toLowerCase();

            //creating id for member.
            String memberID =
                    last.replaceAll("\\p{Punct}", "").toLowerCase()
                            + first.replaceAll("\\p{Punct}", "").toLowerCase()
                            + Integer.toString(age);

            //figure out if household exists, then act accordingly
            if(!households.containsKey(householdID)){ //no household found create a new one.
                //dynamically add new household.
                Household householdObj = new Household(street, city, state, householdID, this.DEBUG);
                householdObj.addMember(first, last, age, memberID); //add member to newly created household
                households = Household.getHouseholds(); //re-pull modified Household hashmap.
            } else { //add member to outstanding household
                households.get(householdID).addMember(first,last,age, memberID);
            }


        }

    }
}
