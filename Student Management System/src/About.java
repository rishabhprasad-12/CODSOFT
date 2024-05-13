import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    /**
     * Constructor for the About class, which initializes the frame with a logo,
     * background image, and text areas.
     */
    About() {
        // Set the icon for the frame
        ImageIcon image = new ImageIcon("Image/Logo.jpg");
        setIconImage(image.getImage());

        // Load and set the background image for the frame
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Image/Background.jpg"));
        Image image2 = image1.getImage().getScaledInstance(1600, 700, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel imglabel = new JLabel(image3);
        add(imglabel);

        // Set the size and location of the frame
        setSize(650, 450);
        setLocation(350, 100);

        // Set the layout of the frame to null
        setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // Set the background color of the form
        getContentPane().setBackground(new Color(154, 219, 245));

        /**
         * Create a JLabel for the heading
         */
        JLabel heading = new JLabel("Project Overview");
        heading.setBounds(25, 30, 300, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        /**
         * Create a JTextArea for the project description
         */
        JTextArea area = new JTextArea(
                "As an intern at Codsoft, I was tasked with developing a Student Management System project using Java Swing"
                        + "\nand AWT. This project aimed to provide functionalities such as Adding, Removing, Updating, and Viewing"
                        + "\nStudent Details, with the underlying Database connectivity being facilitated through MySQL using a JDBC driver."
                        + "\n\nThere're still some bugs in this project, try to solve it out.\nUpdates are available in the future.."
                        + "\n\nLastly, I'm thankful to the CodSoft for providing invaluable opportunities for practical learning and growth."
                        + "\nOvercoming challenges such as connecting my Java project to JDBC reinforced my problem-solving skills and"
                        + "\ndeepened my understanding of JAVA Programing.  I am grateful for the support and mentorship received during"
                        + "\nthis journey, and I am confident that the skills acquired will serve as a solid foundation for my future"
                        + "\nendeavors in software development.");
        area.setBounds(25, 90, 600, 220);
        area.setBackground(new Color(154, 219, 245));
        add(area);

        // Set the JTextArea to not editable if you want it to be read-only
        area.setEditable(false);

        /**
         * Create a JLabel for the developer information
         */
        JLabel dev = new JLabel("Developer:");
        dev.setBounds(25, 320, 100, 30);
        dev.setFont(new Font("Didot", Font.BOLD, 15));
        add(dev);

        /**
         * Create a JLabel for the developer's name
         */
        JLabel dName = new JLabel("Rishabh Shankar Prasad");
        dName.setBounds(120, 320, 250, 30);
        dName.setFont(new Font("Courier", Font.PLAIN, 15));
        add(dName);

        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}