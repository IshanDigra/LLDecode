package LLD_Problems.MEDIUM.LibraryManagementSystem.Service;

import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Book;
import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Loan;
import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class LibraryManagementSystem {
    private BookManager bookManager;
    private MemberManager memberManager;
    private TransactionManager transactionManager;
    private static LibraryManagementSystem instance;
    //private Map<Integer, List<Loan>> loans;

    private LibraryManagementSystem(){
        bookManager = new BookManager();
        memberManager = new MemberManager();
        transactionManager = new TransactionManager();
//        loans = new ConcurrentHashMap<>();
    }
    public static synchronized LibraryManagementSystem getInstance(){
        if(instance == null){
            instance = new LibraryManagementSystem();
        }
        return instance;
    }

//  Book Management
    public synchronized void addBook(Book book){
        bookManager.addBook(book);
    }

    public synchronized void removeBook(int id){
        bookManager.removeBook(id);
    }

    public synchronized Book getBook(int id){
        return bookManager.getBook(id);
    }

//  member management
    public synchronized void addMember(Member member){
        memberManager.addMember(member);
    }
    public synchronized void removeMember(int id){
        memberManager.removeMember(id);
    }

    public Member getMember(int id){
        return memberManager.getMember(id);
    }

//  Transaction management

    public Loan borrowBook(int memberId, int bookId){
        Member member = getMember(memberId);
        Book book = getBook(bookId);

        return transactionManager.borrowBook(member, book);

    }

    public void returnBook(Loan loan, Date date){
       transactionManager.returnBook(loan, date);
    }
}
