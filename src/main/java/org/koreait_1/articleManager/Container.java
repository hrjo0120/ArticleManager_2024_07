package org.koreait_1.articleManager;

import org.koreait_1.dao.ArticleDao;
import org.koreait_1.dao.MemberDao;
import org.koreait_1.service.ArticleService;
import org.koreait_1.service.MemberService;

public class Container {
    public static ArticleDao articleDao;
    public static MemberDao memberDao;

    public static ArticleService articleService;
    public static MemberService memberService;

    public static void init() {
        articleDao = new ArticleDao();
        memberDao = new MemberDao();

        memberService = new MemberService();
        articleService = new ArticleService();
    }
}
