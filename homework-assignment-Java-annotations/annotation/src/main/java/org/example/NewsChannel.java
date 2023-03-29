package org.example;

import java.util.ArrayList;
import java.util.List;

@ChannelInfo(level = 8, type = "новости", description = "Канал, который публикует самые свежие новости со всего мира")
public class NewsChannel {
    private final String name;
    private final List<NewsArticle> articles;

    public NewsChannel(String name) {
        this.name = name;
        articles = new ArrayList<>();
    }

    public void addArticle(NewsArticle article) {
        articles.add(article);
    }

    public List<NewsArticle> getArticles() {
        return articles;
    }

    public String getName() {
        return name;
    }
}
