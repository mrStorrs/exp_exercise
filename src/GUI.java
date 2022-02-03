import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class GUI extends JFrame{
    private String howToSort;
    private Boolean DEBUG;

    public void startGUI(){
        //Creating main frame to hold everything
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
                try {
                    Application.firstRuntime(howToSort, DEBUG);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                runAgain();
            }
        });

        JButton sortByHouseholdButton = new JButton("No");
        sortByHouseholdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DEBUG = false;
                frame.dispose();
                try {
                    Application.firstRuntime(howToSort, DEBUG);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                runAgain();
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

    private void runAgain(){
        //Creating main frame to hold everything
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //Creating the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        BoxLayout boxLayout= new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(boxLayout);

        //creating  heading panel
        JPanel sortHeading = new JPanel();
        sortHeading.add(new JLabel("Would you like too run this again?"));
        mainPanel.add(sortHeading);

        //creating buttons panel
        JPanel sortButtons = new JPanel();

        JButton runAgainButton = new JButton("Yes");
        runAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DEBUG = true;
                frame.dispose();
                Application.repeatRuntime();
            }
        });

        JButton dontRunAgainButton = new JButton("No");
        dontRunAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DEBUG = false;
                frame.dispose();

                System.exit(0);
            }
        });

        sortButtons.add(runAgainButton);
        sortButtons.add(dontRunAgainButton);

        mainPanel.add(sortButtons);

        //adding panels
        frame.add(mainPanel);
        frame.pack(); //this is what dynamically handle frame size.
        frame.setVisible(true);
    }
}
