package LLD_Problems.MEDIUM.LibraryManagementSystem.Model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Member {
    private final int id;
    private final String name;
    private final String contact;
    private int borrowLimit;
    private List<Book> borrowList;
    private List<Book> borrowHistory;

    public Member(int id, String name, String contact, int borrowLimit) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.borrowLimit = borrowLimit;
        borrowList = new CopyOnWriteArrayList<>();
        borrowHistory = new CopyOnWriteArrayList<>();
    }



    public synchronized boolean borrowBook(Book book) {
        if(borrowList.size() >= borrowLimit) {
            System.out.println("Borrow limit reached");
            return false;
        }
        else{
            if(book.isAvailable()){
                borrowList.add(book);;
                book.setAvailable(false);
                return true;
            }
            else {
                System.out.println("Book is not available");
                return false;
            }
        }
    }

    public synchronized boolean returnBook(Book book) {
        if(borrowList.remove(book)){
            borrowHistory.add(book);
            book.setAvailable(true);
            return true;
        }
        return false;
    }





//  getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

//

    public List<Book> getBorrowList() {
        return borrowList;
    }

    public List<Book> getBorrowHistory() {
        return borrowHistory;
    }

    //  setter
    public void setBorrowLimit(int borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder("Member ID: " + id + ", Name: " + name + ", Contact: " + contact);
        details.append("\nBorrowed Books: ");
        for (Book book : borrowList) {
            details.append(book.getDetails()).append(", ");
        }
        return details.toString();
    }

}
