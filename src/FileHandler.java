import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileHandler {
    private String path;
    private int id;
    private static int unique_id;
    private ArrayList<String> rawInput = new ArrayList<String>();
    private Boolean DEBUG;

    public FileHandler(String path){
        this.setPath(path);
        this.DEBUG = false;
    }

    public FileHandler(String path, Boolean DEBUG){
        this.setPath(path);
        this.DEBUG = true;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    //creating a unique id for file.
    private void setId(){
        this.id = FileHandler.unique_id;
        FileHandler.unique_id++;
    }

    /**
     * Logic for reading the file and then outputting each line item (househould)
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
                    System.out.println("Adding raw-data: " + data);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file specified cannot be found.");
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

            //move this to its own method later! creating id to check if household exists.
            String id =
                    state.replaceAll("\\p{Punct}", "").toLowerCase()
                    + city.replaceAll("\\p{Punct}", "").toLowerCase()
                    + street.replaceAll("\\W", "").toLowerCase();

            //figure out if household exists, then act accordingly
            if(!households.containsKey(id)){ //no household found create a new one.
                //dynamically add new household.
                Household householdObj = new Household(street, city, state, id, this.DEBUG);
                householdObj.addMember(first, last, age); //add member to newly created household
                households = Household.getHouseholds(); //re-pull modified Household hashmap.
            } else { //add member to outstanding household
                households.get(id).addMember(first,last,age);
            }


        }

    }
}
