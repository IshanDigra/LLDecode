package LLD_Problems.MEDIUM.LibraryManagementSystem.Model;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final String publicationDate;
    private final String isbn;
    private boolean available;
    private int maximumBorrowDuration;

    public Book(int id, String title, String author, String publicationDate, String isbn, int maximumBorrowDuration) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.available = true;
        this.maximumBorrowDuration = maximumBorrowDuration;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getMaximumBorrowDuration() {
        return maximumBorrowDuration;
    }

    public void setMaximumBorrowDuration(int maximumBorrowDuration) {
        this.maximumBorrowDuration = maximumBorrowDuration;
    }

    public String getDetails() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", ISBN: " + isbn
                + ", Year: " + publicationDate + ", Max Borrow Duration: " + maximumBorrowDuration + ", Status: " + available;
    }
}
