import java.sql.*;

/**
 * This class is used to establish a connection to a MySQL database.
 */
public class Conn {
    /**
     * The Connection object to interact with the database.
     */
    Connection c = null;
    /**
     * The Statement object to execute SQL queries.
     */
    Statement s = null;

    /**
     * Constructor to initialize the connection and statement objects.
     */
    Conn() {
        try {
            /**
             * Registering the MySQL JDBC driver using the fully qualified class name.
             */
            Class.forName("com.mysql.cj.jdbc.Driver");
            /**
             * Establishing a connection to the 'studentmanagementsystem' database on localhost:3306
             * using the username 'root' and password 'Rishabh@12'.
             */
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "root", "Rishabh@12");
            /**
             * Creating a Statement object to execute SQL queries.
             */
            s = c.createStatement();
        } catch (Exception e) {
            /**
             * Printing the stack trace in case of any exception during connection establishment.
             */
            e.printStackTrace();
        }
    }
}