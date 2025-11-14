package LLD_Problems.MEDIUM.LibraryManagementSystem.Model;

import LLD_Problems.MEDIUM.LibraryManagementSystem.Constants.LoanStatus;

import java.util.Date;

public class Loan {
    private final int id;
    private final Book book;
    private final Member member;
    private final Date borrowDate;
    private final Date dueDate;
    private Date returnDate;
    private LoanStatus status;

    public Loan(int id, Book book, Member member, Date borrowDate, Date dueDate) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        status = LoanStatus.ACTIVE;
    }

    public void returnBook(Date returnDate) {
        member.returnBook(book);
        this.returnDate = returnDate;
        status = (returnDate.before(dueDate)) ? LoanStatus.RETURNED : LoanStatus.OVERDUE;

    }

//    getters

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

//    Setters

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public String getDetails() {
        return "Loan ID: " + id + ", Book: " + book.getDetails() + ", Member: " + member.getDetails()
                + ", Borrow Date: " + borrowDate + ", Due Date: " + dueDate + ", Return Date: " + returnDate
                + ", Status: " + status;
    }
}
