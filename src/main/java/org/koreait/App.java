package org.koreait;

import org.koreait.article.controller.ArticleController;

public class App {

    public void run() {

        System.out.println("== Article Manager execution==");

        ArticleController articleController = new ArticleController();
        while(true) {
            System.out.print("명령어) ");
            String cmd = Container.getScanner().nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (cmd) {
                case "article write" :
                    articleController.write();
                    break;
                case "article list" :
                    articleController.list();
                case "article detail" :
                    articleController.detail();

            }
        }
    }
}
