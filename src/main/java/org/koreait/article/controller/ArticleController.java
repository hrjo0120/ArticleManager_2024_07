package org.koreait.article.controller;

import org.koreait.Container;
import org.koreait.article.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    int lastId = 0;
    List<Article> articles = new ArrayList<Article>();

    public void write() {
        int id = lastId + 1;
        System.out.print("제목: ");
        String title = Container.getScanner().nextLine();
        System.out.print("내용: ");
        String contents = Container.getScanner().nextLine();

        Article article = new Article(id, title, contents);

        articles.add(article);

        System.out.printf("%d번 글이 생성되었습니다.\n", id);
        lastId++;
    }

    public void list() {
        if (articles.size() == 0) {
            System.out.println("등록된 Article이 없습니다.");
        }

        System.out.println("   번호   /    제목    /    내용");
        for (int i = articles.size() - 1; i >= 0; i--){
            Article article = articles.get(i);

            System.out.printf("   %d   //   %s   //   %s   \n", article.getId(), article.getTitle(), article.getContents());
        }
    }

    public void detail() {
        if(articles.size() == 0) {
//            ""
        }
    }
}
