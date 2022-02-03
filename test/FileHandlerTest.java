import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @org.junit.jupiter.api.Test
    void setPath() {
        FileHandler a = new FileHandler("testpath", true);
        a.setPath("new testpath");
        assertEquals("new testpath", a.getPath());
    }

    @org.junit.jupiter.api.Test
    void getPath() {
        FileHandler a = new FileHandler("testpath", true);
        assertEquals("testpath", a.getPath());
    }

    @org.junit.jupiter.api.Test
    void readFile() {
        FileHandler a = new FileHandler("./input/test.txt", true);
        a.readFile();
        assertEquals("HelloExpeditors", a.getRawInput().get(0));
    }

    @Test
    void writeHouseholds() {
        // Test when given base input file
        FileHandler a = new FileHandler("./input/INPUT.txt", true);
        a.readFile();
        a.writeHouseholds();
    }

    @Test
    void writeHouseholdsDuplicate() {
        //test for duplicate members
        FileHandler a = new FileHandler("./input/testDuplicate.txt", true);
        a.readFile();
        a.writeHouseholds();
    }
}