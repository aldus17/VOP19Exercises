package mylibrarymanagementsystem.ui.listBook;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import mylibrarymanagementsystem.database.DatabaseHandler;
import mylibrarymanagementsystem.ui.addBook.FXMLDocumentController;

public class BookListController implements Initializable {

    ObservableList<Book> obsList = FXCollections.observableArrayList();
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> idColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> publisherColumn;
    @FXML
    private TableColumn<Book, Boolean> availabilityColumn;
    private DatabaseHandler databaseHandler;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: display data in tables
        // TODO: load data from database

        initColumn();
        databaseHandler = new DatabaseHandler();
        loadData();
    }

    private void loadData() {
        // Data loaded from the database
        String query = "SELECT * FROM BOOK";
        ResultSet resultSet = databaseHandler.execQuery(query);
        try {
            while (resultSet.next()) {
                String titleText = resultSet.getString("title");
                String author = resultSet.getString("author");
                String id = resultSet.getString("id");
                String publisher = resultSet.getString("publisher");
                Boolean availability = resultSet.getBoolean("isAvailable");
                // The data is added to the observableList
                obsList.add(new Book(titleText, id, author, publisher, availability));

            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Associated the data with the values from the observableList
        tableView.getItems().setAll(obsList);
    }

    private void initColumn() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

    }

}
