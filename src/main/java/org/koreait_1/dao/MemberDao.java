package org.koreait_1.dao;

import org.koreait_1.dto.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    public List<Member> members;

    public MemberDao() {
        members = new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }
}
