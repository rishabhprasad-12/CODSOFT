import javax.swing.*;
import java.awt.*;
import java.util.*;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStud extends JFrame implements ActionListener {
    // Declare and initialize text fields and labels and buttons
    private JButton submit, cancel;
    private JTextField tfName, tfFName, tfAddress, tfPhone, tfEmail, tf10, tf12;
    private JLabel labelRollNo;
    @SuppressWarnings("rawtypes")
    private JComboBox cbCourse, cbBranch;
    // JDateChooser dcdob;

    // Initialize random number generator
    Random ran = new Random();

    // Generate a random 4-digit number for the roll number
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    // Constructor to initialize the frame and its components
    @SuppressWarnings({ "rawtypes", "unchecked" })
    AddStud() {

        // Create an ImageIcon object with the image located at "Image/Logo.jpg"
        ImageIcon image = new ImageIcon("Image/Logo.jpg");

        // Set the icon image of the JFrame
        setIconImage(image.getImage());

        // Set the size and location of the frame
        setSize(800, 600);
        setLocation(280, 40);

        // Set the layout of the frame to null
        setLayout(null);

        // Add a heading label
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(270, 20, 450, 40);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        // Add a name label and text field
        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(60, 120, 100, 30);
        lblName.setFont(new Font("serif", Font.BOLD, 20));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200, 120, 150, 30);
        add(tfName);

        // Add a roll number label and label to display the roll number
        JLabel lblRoll = new JLabel("Roll No.: ");
        lblRoll.setBounds(420, 120, 150, 30);
        lblRoll.setFont(new Font("serif", Font.BOLD, 20));
        add(lblRoll);

        labelRollNo = new JLabel("1469" + first4);
        labelRollNo.setBounds(570, 120, 150, 30);
        labelRollNo.setFont(new Font("serif", Font.BOLD, 20));
        add(labelRollNo);

        // Add a father's name label and text field
        JLabel lblFName = new JLabel("Father's Name: ");
        lblFName.setBounds(60, 170, 150, 30);
        lblFName.setFont(new Font("serif", Font.BOLD, 20));
        add(lblFName);

        tfFName = new JTextField();
        tfFName.setBounds(200, 170, 150, 30);
        add(tfFName);

        // Add D.O.B label and calender chooser
        JLabel lblDOB = new JLabel("D.O.B: ");
        lblDOB.setBounds(420, 170, 150, 30);
        lblDOB.setFont(new Font("serif", Font.BOLD, 20));
        add(lblDOB);

        // dcdob = new JDateChooser();
        // dcdob.setBounds(200, 170, 150, 30);
        // add(dcdob);

        // Add a Address label and text field
        JLabel lblAddress = new JLabel("Address: ");
        lblAddress.setBounds(60, 220, 150, 30);
        lblAddress.setFont(new Font("serif", Font.BOLD, 20));
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 220, 520, 30);
        add(tfAddress);

        // Add a phone label and text field
        JLabel lblPhone = new JLabel("Phone No.: ");
        lblPhone.setBounds(60, 270, 150, 30);
        lblPhone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(200, 270, 150, 30);
        add(tfPhone);

        // Add a email label and text field
        JLabel lblEmail = new JLabel("Email: ");
        lblEmail.setBounds(420, 270, 150, 30);
        lblEmail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(570, 270, 150, 30);
        add(tfEmail);

        // Add class 10% label and text field
        JLabel lbl10 = new JLabel("Class X (%): ");
        lbl10.setBounds(60, 320, 150, 30);
        lbl10.setFont(new Font("serif", Font.BOLD, 20));
        add(lbl10);

        tf10 = new JTextField();
        tf10.setBounds(200, 320, 150, 30);
        add(tf10);

        // Add class 12% label and text field
        JLabel lbl12 = new JLabel("Class XII (%): ");
        lbl12.setBounds(420, 320, 150, 30);
        lbl12.setFont(new Font("serif", Font.BOLD, 20));
        add(lbl12);

        tf12 = new JTextField();
        tf12.setBounds(570, 320, 150, 30);
        add(tf12);

        // Add course label and dropDown
        JLabel lblCourse = new JLabel("Faculty: ");
        lblCourse.setBounds(60, 370, 150, 30);
        lblCourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblCourse);

        String course[] = { "B.Tech", "BCA", "BBA", "B.Sc", "B.Com", "B.A." };
        cbCourse = new JComboBox(course);
        cbCourse.setBounds(200, 370, 150, 30);
        add(cbCourse);

        // Add course label and dropDown
        JLabel lblBranch = new JLabel("Branch: ");
        lblBranch.setBounds(420, 370, 150, 30);
        lblBranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblBranch);

        String branch[] = { " -- ", "Computer Science", "IT", "Electronics", "Mechanical", "Civil" };
        cbBranch = new JComboBox(branch);
        cbBranch.setBounds(570, 370, 150, 30);
        add(cbBranch);

        submit = new JButton("Submit");
        submit.setBounds(250, 470, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(430, 470, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        // Set the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the source of the action event
        if (e.getSource() == submit) {
            // Get the text from the text fields
            String name = tfName.getText();
            String roll = labelRollNo.getText();
            String fname = tfFName.getText();
            // String dob = (JTextField) dcdob.getDateEditor().getComponent()).getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String x = tf10.getText();
            String xii = tf12.getText();
            String course = (String) cbCourse.getSelectedItem();
            String branch = (String) cbBranch.getSelectedItem();

            try {
                // Create a SQL query to insert the student details into the database
                String query = "insert into student values('" + name + "', '" + roll + "', '" + fname + "', '" + address
                        + "', '" + phone + "', '" + email + "', '" + x + "', '" + xii + "', '" + course + "', '"
                        + branch + "')";

                // Execute the SQL query
                Conn c = new Conn();
                c.s.executeUpdate(query);

                // Display a success message
                JOptionPane.showMessageDialog(null, "Student's Detail Inserted Successfully");
                setVisible(false);

            } catch (Exception ae) {
                // Display an error message if there is an exception
                ae.printStackTrace();
            }

        }
        // Hide the frame when the cancel button is clicked
        setVisible(false);
    }

    // Main method to create an instance of the AddStud class
    public static void main(String[] args) {
        new AddStud();
    }
}