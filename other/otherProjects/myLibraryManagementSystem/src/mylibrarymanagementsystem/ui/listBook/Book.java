package mylibrarymanagementsystem.ui.listBook;

public class Book {

    private final String title;
    private final String id;
    private final String author;
    private final String publisher;
    private final Boolean availability;

    public Book(String title, String id, String author, String publisher, Boolean availability) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.publisher = publisher;
        this.availability = availability;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public Boolean getAvailability() {
        return availability;
    }

    
}
