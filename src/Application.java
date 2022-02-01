import java.io.File;  // for handling files.
import java.io.FileNotFoundException;  // error handling
import java.util.Scanner; // used to read text files

public class Application {
    public static void main(String[] args){
        try {
            File input = new File("./input/INPUT.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file specified cannot be found.");
            e.printStackTrace();
        }
    }
}
