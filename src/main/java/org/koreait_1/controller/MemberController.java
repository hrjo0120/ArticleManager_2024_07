package org.koreait_1.controller;

import org.koreait_1.dto.Member;
import org.koreait_1.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberController extends Controller {
    private Scanner sc;
    private List<Member> members;
    private String cmd;

    private int lastMemberId = 3;

    public MemberController(Scanner sc) {
        this.sc = sc;
        members = new ArrayList<>();
    }

    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;

        switch (actionMethodName) {
            case "join":
                doJoin();
                break;
            case "login":   // 해당 프로그램에 내가 누구인지 알게하는 행위
                doLogin();
                break;
            case "logout":
                doLogout();
                break;
            default:
                System.out.println("명령어 확인 (actionMethodName) 오류");
                break;
        }
    }

    private void doJoin() {
        System.out.println("== 회원 가입 ==");
        int id = lastMemberId + 1;
        String regDate = Util.getNow();
        String loginId = null;
        // ID 중복확인 - 기존에 있는거랑 확인
        while (true) {
            System.out.print("아이디: ");
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
        System.out.print("이름: ");
        String name = sc.nextLine();

        Member member = new Member(id, regDate, loginId, loginPw, name);
        members.add(member);
        System.out.println(id + "번 회원이 가입되었습니다");
        lastMemberId++;
    }

    private void doLogin() {
        System.out.println("== 로그인 ==");

        System.out.print("로그인 아이디 : ");
        String loginId = sc.nextLine().trim();
        System.out.print("비밀번호 : ");
        String loginPw = sc.nextLine();

        // 회원가입이 되어있는지 확인 -> 사용자가 방금 입력한 로그인 아이디랑 일치하는 회원이 나한테 있는지 확인
        Member member = getMemberByLoginId(loginId);

        if (member == null) {
            System.out.println("일치하는 회원이 없습니다.");
            return;
        }

        // 있는 회원일 경우 -> 내가 알고있는 비밀번호가 사용자가 입력한 비밀번호와 일치하는지 따져봐야함.
        if (member.getLoginPw().equals(loginPw) == false) {
            System.out.println("비밀번호를 다시 확인해주세요.");
            return;
        }

        loginedMember = member; // 누가 로그인 했는가?

        System.out.printf("%s님 로그인 성공\n", member.getName());

    }

    private void doLogout() {
        loginedMember = null;
        System.out.println("로그아웃 되었습니다");
    }

    private boolean isJoinableLoginId(String loginId) {
        for (Member member : members) {
            if (member.getLoginId().equals(loginId)) {
                return false;
            }
        }
        return true;
    }

    private Member getMemberByLoginId(String loginId) {
        for (Member member : members) {
            if (member.getLoginId().equals(loginId)) {
                return member;
            }
        }
        return null;    //못찾았으면 아무것도 주지마
    }

    public void makeTestData() {
        System.out.println("회원 테스트 데이터 생성");
        members.add(new Member(1, Util.getNow(), "test1", "test1", "김철수"));
        members.add(new Member(2, Util.getNow(), "test2", "test2", "김영희"));
        members.add(new Member(3, Util.getNow(), "test3", "test3", "홍길동"));
    }
}
