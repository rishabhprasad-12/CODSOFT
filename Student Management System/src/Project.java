import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    // Constructor to initialize the frame and its components
    Project() {
        // Set the size of the frame
        setSize(1540, 700);

        // Set the default close operation for the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the icon for the frame
        ImageIcon image = new ImageIcon("Image/Logo.jpg");
        setIconImage(image.getImage());

        // Load and set the background image for the frame
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Image/Background.jpg"));
        Image image2 = image1.getImage().getScaledInstance(1600, 700, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel imglabel = new JLabel(image3);
        add(imglabel);

        // Create and add a menu bar to the frame
        JMenuBar mb = new JMenuBar();

        // Create and add a "About" menu to the menu bar
        JMenu Info = new JMenu("About");
        Info.setForeground(new Color(128, 0, 0));
        mb.add(Info);

        // Create and add a "About Project" menu item to the "About" menu
        JMenuItem moreInfo = new JMenuItem("About Project");
        moreInfo.setForeground(new Color(178, 34, 34));
        moreInfo.addActionListener(this);
        Info.add(moreInfo);

        // Create and add a "Details" menu to the menu bar
        JMenu details = new JMenu("Details");
        details.setForeground(new Color(128, 0, 0));
        mb.add(details);

        // Create and add a "Add New Student" menu item to the "Details" menu
        JMenuItem newStd = new JMenuItem("Add New Student");
        newStd.setForeground(new Color(178, 34, 34));
        newStd.addActionListener(this);
        details.add(newStd);

        // Create and add a "Remove Student" menu item to the "Details" menu
        JMenuItem removeStd = new JMenuItem("Update Student Detail");
        removeStd.setForeground(new Color(178, 34, 34));
        removeStd.addActionListener(this);
        details.add(removeStd);

        // Create and add a "View Details" menu item to the "Details" menu
        JMenuItem showDetails = new JMenuItem("View Details");
        showDetails.setForeground(new Color(178, 34, 34));
        showDetails.addActionListener(this);
        details.add(showDetails);

        // Create and add an "Exit" menu to the menu bar
        JMenu exit = new JMenu("Exit");
        exit.setForeground(new Color(128, 0, 0));
        mb.add(exit);

        // Create and add an "Exit" menu item to the "Exit" menu
        JMenuItem ex = new JMenuItem("Exit");
        ex.setForeground(new Color(178, 34, 34));
        ex.addActionListener(this);
        exit.add(ex);

        // Add the menu bar to the frame
        setJMenuBar(mb);

        // Set the frame to be visible
        setVisible(true);
    }

    // Override the actionPerformed method to handle menu item clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the action command of the menu item that was clicked
        String str = e.getActionCommand();

        if (str.equals("About Project")) {  
            new About();
        }else if (str.equals("Add New Student")) {
            new AddStud();
        } else if (str.equals("Update Student Detail")) {
            new UpdateStud();
        } else if (str.equals("View Details")) {
            new ViewDetails();
        } else {
            setVisible(false);
        }
    }

    // Main method to create and run the application
    public static void main(String[] args) {
        // Create a new instance of the Project class
        new Project();
    }
}