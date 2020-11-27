package mylibrarymanagementsystem.database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseHandler {

    private static DatabaseHandler dbHandler;

    private static String DB_URL = "jdbc:derby:database/library2;create=true";  // :database/library2;create=true creates folder where the derby database files will be stored
    private static Connection connection = null;    // Stores connections between java and database
    private static Statement statement = null;      // 

    public DatabaseHandler() {
        createConnection();
        setupBookTable();
    }
    
    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();    // loading driver from derby.jar
            connection = DriverManager.getConnection(DB_URL);
        } catch (ClassNotFoundException e) {
         System.out.println("Exception at createConnection:DatabaseHandler"
                    + "the class cannot be located" + e.getLocalizedMessage());
        } catch (InstantiationException e) {
            System.out.println("Exception at createConnection:DatabaseHandler"
                    + "this Class represents an abstract class, an interface, an array class, a primitive type, or void"
                    + " or the class has no nullary constructor"
                    + "or the instantiation fails for some other reason" + e.getLocalizedMessage());
        } catch (IllegalAccessException e) {
           System.out.println("Exception at createConnection:DatabaseHandler"
                    + "the class or its nullary constructor is not accessible." + e.getLocalizedMessage());
        } catch (SQLException e) {
             System.out.println("Exception at createConnection:DatabaseHandler"
                    + "a database access error occured or the url is null" + e.getLocalizedMessage());
        }
    }

    private void setupBookTable() {
        String TABLE_NAME = "BOOK"; // Table name
        try {
            statement = connection.createStatement();   // Create statment object from database connection, useful for executing commands

            // Access meta data and check if there is a table called BOOK in the database
            // if there is not a table called BOOK only then we want to create a table called BOOK
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                statement.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "id VARCHAR(200) primary key," // used to uniquely identify a book from table
                        + "title VARCHAR(200),"
                        + "author VARCHAR(200),"
                        + "publisher VARCHAR(200),"
                        + "isAvailable BOOLEAN default true" // Book should be available from start when added
                        + ")");
            }
        } catch (SQLException e) {
            System.out.println("Exception at setupBookTable:DatabaseHandler"
                    + "database access error occured" + e.getLocalizedMessage());
        }
    }

    /**
     * Exectuting query e.g. like a select statement
     *
     * @param query
     * @return
     */
    public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Exception at execQuery:DatabaseHandler" + e.getLocalizedMessage());
            return null;
        } finally {

        }
        return result;
    }

    /**
     * Doing action on the database, e.g. inserting data, creating a table etc.
     * return boolean if action was successfull
     *
     * @param qa
     * @return
     */
    public boolean execAction(String qa) {
        try {
            statement = connection.createStatement();
            statement.execute(qa);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execQuery:DatabaseHandler" + e.getLocalizedMessage());
            return false;
        } finally {

        }
    }
}
