package LLD_Problems.MEDIUM.LibraryManagementSystem.Service;

import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Book;
import LLD_Problems.MEDIUM.LibraryManagementSystem.Model.Member;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemberManager {
    private Map<Integer, Member> members;
    public MemberManager() {
        members = new ConcurrentHashMap<>();
    }

    public void addMember(Member member){
        members.put(member.getId(), member);
    }
    public Member getMember(int id){
        return members.get(id);
    }

    public void removeMember(int id){
        members.remove(id);
    }

    public List<Book> getBorrowedBooks(int id){
        Member member = getMember(id);
        return member.getBorrowList();
    }
}
