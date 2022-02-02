import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileHandler {
    private String path;
    private int id;
    private static int unique_id;
    private ArrayList<String> rawInput = new ArrayList<String>();
    private Boolean DEBUG;

    //this will hold all the households after they are cleaned from all files.
    private static ArrayList<Household> households = new ArrayList<>();

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

    public void writeHouseholds(){
        //retrieve current households.
        System.out.println(Household.getInstances());
        ArrayList<String> currentHouseholds = Household.getInstances();

        for(String household : this.rawInput){
            //split and convert to array to be assigned. MOVE TO READ
            List<String> householdArr = Arrays.asList(household.split(","));
            System.out.println("householdarr: " + householdArr);

            //set ids for construction of new household.
//            String first = householdArr.get(0);
//            String last = householdArr.get(1);
            String street = householdArr.get(2);
            String city = householdArr.get(3);
            String state = householdArr.get(4);
//            String age = householdArr.get(5);


            //move this to its own method later! creating id
            String id =
                    state.replaceAll("\\p{Punct}", "").toLowerCase()
                    + city.replaceAll("\\p{Punct}", "").toLowerCase()
                    + street.replaceAll("\\W", "").toLowerCase();

            //adding
            if(!currentHouseholds.contains(id)){
                //dynamically add new household.
                Household householdObj = new Household(street, city, state, id, this.DEBUG);
                households.add(householdObj);
                System.out.println("Creating new household: " + id);

            }


        }
        System.out.println(households);

    }
}
