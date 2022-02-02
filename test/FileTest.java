import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @org.junit.jupiter.api.Test
    void setPath() {
        File a = new File("testpath");
        a.setPath("new testpath");
        assertEquals("new testpath", a.getPath());
    }

    @org.junit.jupiter.api.Test
    void getPath() {
        File a = new File("testpath");
        assertEquals("testpath", a.getPath());
    }

    @org.junit.jupiter.api.Test
    void readFile() throws FileNotFoundException {
        File a = new File("./input/test.txt");
        assertEquals("HelloExpeditors", a.readFile());
    }
}