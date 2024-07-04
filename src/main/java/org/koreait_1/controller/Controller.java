package org.koreait_1.controller;

import org.koreait_1.dto.Member;

public abstract class Controller {
    protected static Member loginedMember = null;

    public abstract void doAction(String cmd, String actionMethodName); // 이게 없으면 안되는 이유? 형변환이 일어나는 과정에서 버튼을 잃어버릴 수도 있기 때문에  필요함

    public static boolean isLogined() {
        return loginedMember != null;
    }

    public void makeTestData() {

    }
}
