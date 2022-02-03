import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsoleGUI {
    final JFrame frame = new JFrame();
    public ConsoleGUI() {
        JTextArea textArea = new JTextArea(24, 80);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.LIGHT_GRAY);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textArea.append(String.valueOf((char) b));
            }
        }));
        frame.add(scrollPane);
    }
    public void init() {
        frame.pack();
        frame.setVisible(true);
        setWindowCenterRight();
    }
    public JFrame getFrame() {
        return frame;
    }

    private void setWindowCenterRight(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) (rect.getMaxX() - frame.getWidth() * 1.75) ;
        int y = (int) (rect.getMaxY() - frame.getHeight()) / 2;
        frame.setLocation(x,y);
    }

}
