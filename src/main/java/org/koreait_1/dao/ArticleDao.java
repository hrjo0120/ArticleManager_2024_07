package org.koreait_1.dao;

import org.koreait_1.dto.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    public List<Article> articles;

    public ArticleDao() {
        articles = new ArrayList<>();
    }
}
