package LLD_Problems.MEDIUM.LibraryManagementSystem;

import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Book;
import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Loan;
import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Member;
import LLD_Problems.MEDIUM.LibraryManagementSystem.Service.LibraryManagementSystem;

import java.util.Calendar;

public class LibraryManagementSystemDemo {
    public static void main(String[] args) {
        LibraryManagementSystem lms = LibraryManagementSystem.getInstance();

        // Create books and members
        Book book1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "1925", 14);
        Book book2 = new Book(2, "1984", "George Orwell", "9780451524935", "1949", 14);

        lms.addBook(book1);
        lms.addBook(book2);

        // Create member
        Member member1 = new Member(101, "John Doe", "john@example.com", 2);
        lms.addMember(member1);

        Loan loan  = lms.borrowBook(101,1);
        if (loan != null) {
            System.out.println("Book borrowed successfully!");
            System.out.println(loan.getDetails());
        }


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5); // Return after 5 days
        lms.returnBook(loan, calendar.getTime());

        System.out.println("Book returned successfully!");
        System.out.println(loan.getDetails());
    }
}
