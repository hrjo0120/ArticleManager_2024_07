package org.article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberController {
    Scanner sc;
    List<Member> members;

    private int lastmemberId = 3;

    public MemberController(Scanner sc) {
        this.sc = sc;
        members = new ArrayList<>();
    }

    public void doJoin() {
        System.out.println("== 회원 가입 ==");
        int id = lastmemberId + 1;
        String regDate = Util.getNow();
        String loginId = null;
        // ID 중복확인 - 기존에 있는거랑 확인
        while (true) {
            System.out.print("아이디를 입력해주세요: ");
            loginId = sc.nextLine().trim();
            if (isJoinableLoginId(loginId) == false) {
                System.out.println("이미 사용 중인 ID 입니다.");
                continue;
            }
            System.out.println("사용가능한 ID 입니다.");
            break;
        }
        String loginPw = null;
        // 비밀번호 확인 - 내가 입력한 값끼리 확인
        while (true) {
            System.out.print("비밀번호 : ");
            loginPw = sc.nextLine();
            System.out.print("비밀번호 확인 : ");
            String loginPwConfirm = sc.nextLine();

            if (loginPw.equals(loginPwConfirm) == false) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                continue;
            }
            break;
        }
        System.out.print("이름을 입력해주세요: ");
        String name = sc.nextLine();

        Member member = new Member(id, regDate, loginId, loginPw, name);
        members.add(member);
        System.out.println(id + "번 회원이 가입되었습니다");
        lastmemberId++;
    }

    private boolean isJoinableLoginId (String loginId){
        for (Member member : members) {
            if (member.getLoginId().equals(loginId)) {
                return false;
            }
        }
        return true;
    }

    public void makeTestData () {
        System.out.println("회원 테스트 데이터 생성");
        members.add(new Member(1, Util.getNow(), "qwe", "123", "name1"));
        members.add(new Member(2, Util.getNow(), "asd", "123", "name2"));
        members.add(new Member(3, Util.getNow(), "zxc", "123", "name3"));
    }
}
