package org.koreait_1.service;

import org.koreait_1.articleManager.Container;
import org.koreait_1.dao.MemberDao;
import org.koreait_1.dto.Member;

import java.util.List;

public class MemberService {
    private MemberDao memberDao;

    public MemberService() {
        memberDao = Container.memberDao;
    }

    public List<Member> getMembers() {
        return memberDao.getMembers();
    }
}
