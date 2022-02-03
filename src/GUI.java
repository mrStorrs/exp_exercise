import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class GUI extends JFrame{
    private String howToSort;
    private Boolean DEBUG;
    private String saveFilePath;


    public void startGUI(){
        //Creating main frame to hold everything
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //Creating the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        BoxLayout boxLayout= new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(boxLayout);

        //creating  heading panel
        JPanel sortHeading = new JPanel();
        sortHeading.add(new JLabel("Please choose sorting method"));
        mainPanel.add(sortHeading);

        //creating buttons panel
        JPanel sortButtons = new JPanel();

        JButton sortByMemberButton = new JButton("By Members");
        sortByMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                howToSort = "sortByMembers";
                frame.dispose();
                debugGUI();
            }
        });

        JButton sortByHouseholdButton = new JButton("By Household");
        sortByHouseholdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                howToSort = "sortByHousehold";
                frame.dispose();
                debugGUI();
            }
        });

        sortButtons.add(sortByMemberButton);
        sortButtons.add(sortByHouseholdButton);

        mainPanel.add(sortButtons);

        //adding panels
        frame.add(mainPanel);
        frame.pack(); //this is what dynamically handle frame size.
        frame.setVisible(true);
    }

    private void debugGUI(){
        //Creating main frame to hold everything
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //Creating the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        BoxLayout boxLayout= new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(boxLayout);

        //creating  heading panel
        JPanel sortHeading = new JPanel();
        sortHeading.add(new JLabel("Would you like Debug info?"));
        mainPanel.add(sortHeading);

        //creating buttons panel
        JPanel sortButtons = new JPanel();

        JButton sortByMemberButton = new JButton("Yes");
        sortByMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DEBUG = true;
                frame.dispose();
//                JFileChooser fileChooser = new JFileChooser();
//                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//                int option = fileChooser.showSaveDialog(frame);
//                if(option == JFileChooser.APPROVE_OPTION) {
//                    File file = fileChooser.getSelectedFile();
//                    saveFilePath = file.getPath();
//                }
                try {
                    saveFile(frame);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton sortByHouseholdButton = new JButton("No");
        sortByHouseholdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DEBUG = false;
                frame.dispose();
                try {
                    saveFile(frame);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        sortButtons.add(sortByMemberButton);
        sortButtons.add(sortByHouseholdButton);

        mainPanel.add(sortButtons);

        //adding panels
        frame.add(mainPanel);
        frame.pack(); //this is what dynamically handle frame size.
        frame.setVisible(true);
    }

    public void saveFile(Frame frame) throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showSaveDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            saveFilePath = file.getPath();

            Application.finalRuntime(howToSort, saveFilePath, DEBUG);
        }
    }
}
