package org.koreait_1.articleManager;

import org.koreait_1.dao.ArticleDao;
import org.koreait_1.dao.MemberDao;

public class Container {
    public static ArticleDao articleDao;
    public static MemberDao memberDao;

    static {
        articleDao = new ArticleDao();
        memberDao = new MemberDao();
    }
}
