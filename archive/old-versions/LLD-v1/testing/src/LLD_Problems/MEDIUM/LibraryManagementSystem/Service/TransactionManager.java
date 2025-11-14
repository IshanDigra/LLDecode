package LLD_Problems.MEDIUM.LibraryManagementSystem.Service;

import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Book;
import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Loan;
import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Member;

import java.util.Calendar;
import java.util.Date;

public class TransactionManager {
    private int loanCounter;

    public TransactionManager() {
        this.loanCounter = 0;
    }

    public Loan borrowBook(Member member, Book book){
        if(member.borrowBook(book)){
            Date borrowDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(borrowDate);
            calendar.add(Calendar.DAY_OF_YEAR, book.getMaximumBorrowDuration());
            Date dueDate = calendar.getTime();
            Loan loan = new Loan(loanCounter++,book,member,new Date(), dueDate);

            return loan;
        }
        return null;
    }

    public boolean returnBook(Loan loan, Date returnDate){
        loan.returnBook(returnDate);
        return true;
    }
}
