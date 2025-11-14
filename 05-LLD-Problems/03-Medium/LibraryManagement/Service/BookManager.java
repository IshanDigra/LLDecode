package LLD_Problems.MEDIUM.LibraryManagementSystem.Service;

import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Book;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BookManager {
    private Map<Integer, Book> books;

    public BookManager() {
        books = new ConcurrentHashMap<>();
    }

    public void addBook(Book book){
        books.put(book.getId(), book);
    }

    public Book getBook(int id){
        return books.get(id);
    }

    public boolean removeBook(int id){
        return (books.remove(id)!=null);
    }
}
