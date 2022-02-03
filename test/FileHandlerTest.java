import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    static InputStream inputStream;
    static FileHandler a;

    @BeforeAll
    public static void setUp(){
        InputStream inputStream = Application.class.getResourceAsStream("INPUT.txt");
        FileHandler a = new FileHandler(inputStream, true);
    }

    @Test
    void writeHouseholds() {
        // Test when given base input file
        a.readFile();
        a.writeHouseholds();
    }
}