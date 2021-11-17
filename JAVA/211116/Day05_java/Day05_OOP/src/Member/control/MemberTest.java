package Member.control;

import java.util.ArrayList;
import java.util.List;

import Member.entity.Member;

public class MemberTest {
    public static void main(String[] args) throws Exception {
        Member mem1 = new Member(1, "홍길동", "20120212", 3);
        Member mem2 = new Member(2, "김길동", "20120812", 2);
        Member mem3 = new Member(3, "이길동", "20130112", 10);
        Member mem4 = new Member(4, "박길동", "20110912", 11);
        Member mem5 = new Member(5, "최길동", "20100712", 6);
        Member mem6 = new Member(6, "한길동", "20120112", 8);

        List<Member> members = new ArrayList<Member>();
        members.add(mem1);
        members.add(mem2);
        members.add(mem3);
        members.add(mem4);
        members.add(mem5);
        members.add(mem6);
        for (Member member : members) {
            member.showMemberInfo();
        }

    }
}
