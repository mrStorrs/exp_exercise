import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @org.junit.jupiter.api.Test
    void setPath() {
        FileHandler a = new FileHandler("testpath");
        a.setPath("new testpath");
        assertEquals("new testpath", a.getPath());
    }

    @org.junit.jupiter.api.Test
    void getPath() {
        FileHandler a = new FileHandler("testpath");
        assertEquals("testpath", a.getPath());
    }

    @org.junit.jupiter.api.Test
    void readFile() {
        FileHandler a = new FileHandler("./input/test.txt");
        a.readFile();
        assertEquals("HelloExpeditors", a.getRawInput().get(0));
    }

    @Test
    void getRawInput() {
    }
}