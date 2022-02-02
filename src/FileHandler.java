import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
}
