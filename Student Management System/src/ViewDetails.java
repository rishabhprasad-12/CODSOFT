import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import net.proteanit.sql.*;

public class ViewDetails extends JFrame implements ActionListener { // Class for viewing student details

    private Choice cRoll; // Choice component for selecting roll number
    private JTable table; // Table component for displaying student data
    private JButton search, add, update, remove, cancel; // Button components for various actions

    ViewDetails() {
        // Create an ImageIcon object with the image located at "Image/Logo.jpg"
        ImageIcon image = new ImageIcon("Image/Logo.jpg");

        // Set the icon image of the JFrame
        setIconImage(image.getImage());
        setLayout(null);

        JLabel heading = new JLabel("Students' Detail"); // Heading label
        heading.setBounds(300, 20, 400, 30);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel heading2 = new JLabel("Search by Roll No. "); // Sub-heading label
        heading2.setBounds(40, 75, 180, 20);
        heading2.setFont(new Font("Courier", Font.BOLD, 15));
        add(heading2);

        cRoll = new Choice(); // Choice component for selecting roll number
        cRoll.setBounds(240, 75, 200, 20);
        add(cRoll);

        try {
            Conn c = new Conn(); // Establish connection to the database
            ResultSet rs = c.s.executeQuery("select * from student"); // Execute query to fetch all student data
            while (rs.next()) {
                cRoll.add(rs.getString("roll")); // Add roll numbers to the choice component
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable(); // Table component for displaying student data
        try {
            Conn c = new Conn(); // Establish connection to the database
            ResultSet rs = c.s.executeQuery("select * from student"); // Execute query to fetch all student data
            table.setModel(new StudentTableModel(rs)); // Set table model with student data
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scroll = new JScrollPane(table); // Scroll pane for the table component
        scroll.setBounds(0, 140, 800, 600);
        add(scroll);

        search = new JButton("Search"); // Search button
        search.setBounds(40, 105, 80, 20);
        search.addActionListener(this);
        add(search);

        add = new JButton("Add"); // Add button
        add.setBounds(140, 105, 80, 20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update"); // Update button
        update.setBounds(240, 105, 80, 20);
        update.addActionListener(this);
        add(update);

        remove = new JButton("Remove"); // Remove button
        remove.setBounds(340, 105, 90, 20);
        remove.addActionListener(this);
        add(remove);

        cancel = new JButton("Exit"); // Cancel button
        cancel.setBounds(450, 105, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        // Set the size and location of the frame
        setSize(800, 600);
        setLocation(280, 40);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {

            String query = "select * from student where roll = '" + cRoll.getSelectedItem() + "'"; // Query to search
                                                                                                   // student data by
                                                                                                   // roll number
            try {
                Conn c = new Conn(); // Establish connection to the database
                ResultSet rs = c.s.executeQuery(query); // Execute query to fetch student data
                table.setModel(new StudentTableModel(rs)); // Set table model with student data
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == add) {

            setVisible(false);
            new AddStud(); // Open add student form

        } else if (e.getSource() == update) {

            setVisible(false);
            new UpdateStud(); // Open update student form

        } else if (e.getSource() == remove) {

            String query = "delete from student where roll = '" + cRoll.getSelectedItem() + "'"; // Query to delete
                                                                                                 // student data by roll
                                                                                                 // number
            try {
                Conn c = new Conn(); // Establish connection to the database
                c.s.executeUpdate(query); // Execute query to delete student data

                JOptionPane.showMessageDialog(null, "Student's Detail Removed Successfully"); // Display success message
                setVisible(true);

            } catch (Exception ae) {
                ae.printStackTrace();
            }
            setVisible(false);

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewDetails();
    }
}