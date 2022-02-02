import java.io.FileNotFoundException;
import java.util.Scanner;

public class File {
    private String path;
    private int id;
    private static int unique_id;

    public File(String path){
        this.setPath(path);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    //creating a unique id for file.
    private void setId(){
        this.id = File.unique_id;
        File.unique_id++;
    }

    public String readFile() throws FileNotFoundException {
        java.io.File input = new java.io.File(this.path);
        Scanner reader = new Scanner(input);
        String data = reader.nextLine();
        reader.close();
        return data;
    }
}
