import java.awt.*; // Importing the Color class from the java.awt package
import javax.swing.*; // Importing the ImageIcon class from the javax.swing package

// Creating a class named Start that extends JFrame and implements Runnable
public class Start extends JFrame implements Runnable { 

    // Constructor for Start class
    Start() {
        // Setting the title of the JFrame
        setTitle("Student Managment System");

        // Setting the default close operation of the JFrame to exit the application when closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the JFrame to be not resizable
        setResizable(false);

        // Creating an ImageIcon object with the image located at "Image/Logo.jpg"
        ImageIcon image = new ImageIcon("Image/Logo.jpg");

        // Setting the icon image of the JFrame
        setIconImage(image.getImage());

        // Creating a new Thread object and starting it
        Thread thread = new Thread(this);
        thread.start();

        // Load and set the background image for the frame
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Image/Interface.png"));
        Image image2 = image1.getImage().getScaledInstance(650, 380, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel imglabel = new JLabel(image3);
        add(imglabel);

        // Setting the JFrame to be visible
        setVisible(true);

        // Loop to animate the JFrame's size and location
        for(int i = 2, x = 1; i <= 350; i+=4, x+=1) {
            setLocation(550 - ((i + x)/2), 300 - (i/2));
            setSize(i + 3*x, i + x/2);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                
            }
        }
    }

    // Implementing the run method from the Runnable interface
    @Override
    public void run() {
        try {
            // Pausing the thread for 6000 milliseconds
            Thread.sleep(7000);

            // Hiding the JFrame
            setVisible(false);

            // Creating a new instance of the Login class
            new Login();
        } catch (Exception e) {}
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Creating a new instance of the Start class
        new Start();
    }
}