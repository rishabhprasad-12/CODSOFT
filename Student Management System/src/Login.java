import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 * This class represents a Login form using Java Swing.
 * It contains a constructor to initialize and set up the Login form,
 * and an actionPerformed method to handle button clicks.
 */
public class Login extends JFrame implements ActionListener {

    // Buttons for Login and Cancel actions
    private JButton login, cancel;
    private JTextField tfusername, tfpass;

    /**
     * Constructor to initialize and set up the Login form.
     * It sets the title, icon, size, location, and background color of the form,
     * adds labels, text fields, and buttons to the form,
     * and sets the action listener for the buttons.
     */
    public Login() {
        // Set the title of the form
        setTitle("Login");

        // Setting the default close operation of the JFrame to exit the application
        // when closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the icon of the form
        ImageIcon image = new ImageIcon("Image/Logo.jpg");
        setIconImage(image.getImage());

        // Set the size and location of the form
        setSize(550, 250);
        setLocation(400, 200);
        setResizable(false);

        // Set the background color of the form
        getContentPane().setBackground(new Color(0x123456));
        setLayout(null);

        // Add a label and text field for the username
        JLabel lblusername = new JLabel("Username: ");
        lblusername.setBounds(50, 40, 150, 20);
        lblusername.setForeground(Color.white);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 40, 150, 20);
        add(tfusername);

        // Add a label and password field for the password
        JLabel lblpass = new JLabel("Password: ");
        lblpass.setBounds(50, 80, 150, 20);
        lblpass.setForeground(Color.white);
        add(lblpass);

        tfpass = new JPasswordField();
        tfpass.setBounds(150, 80, 150, 20);
        add(tfpass);

        // Add a Login button and set its properties
        login = new JButton("Login");
        login.setBounds(60, 140, 100, 30);
        login.setBackground(new Color(100, 150, 200));
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        // Add a Cancel button and set its properties
        cancel = new JButton("Cancel");
        cancel.setBounds(190, 140, 100, 30);
        cancel.setBackground(new Color(100, 150, 200));
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        // Add an image to the form
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Image/user.png"));
        Image image2 = image1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel imglabel = new JLabel(image3);
        imglabel.setBounds(340, 25, 150, 150);
        add(imglabel);

        setVisible(true);
    }

    /**
     * Implement the ActionListener interface to handle button clicks.
     * If the Login button is clicked, it gets the username and password from the
     * text fields,
     * queries the database to check if the username and password are valid,
     * and if they are, hides the form and opens the Project form.
     * If the Cancel button is clicked, it hides the form.
     * 
     * @param e the ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpass.getText();

            String query = "select * from login where username = '" + username + "' and password = '" + password + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        }
        setVisible(false);
    }

    /**
     * The main method to run the Login form.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Login();
    }
}