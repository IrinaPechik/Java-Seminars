package org.example;

public class Main {
    public static void main(String[] args) {
        NewsChannel newsChannel = new NewsChannel("Новости");
        NewsArticle article1 = new NewsArticle("Заголовок 1", "Содержание новости 1");
        NewsArticle article2 = new NewsArticle("Заголовок 2", "Содержание новости 2");
        NewsArticle article3 = new NewsArticle("Заголовок 3", "Содержание новости 3");

        newsChannel.addArticle(article1);
        newsChannel.addArticle(article2);
        newsChannel.addArticle(article3);

        System.out.println("Название канала: " + newsChannel.getName());
        System.out.println("Описание канала: " + newsChannel.getClass().getAnnotation(ChannelInfo.class).description());
        System.out.println("Тип канала: " + newsChannel.getClass().getAnnotation(ChannelInfo.class).type());
        System.out.println("Уровень канала: " + newsChannel.getClass().getAnnotation(ChannelInfo.class).level());

        System.out.println("Список новостей:");
        for (NewsArticle article : newsChannel.getArticles()) {
            System.out.println(article.getTitle());
            System.out.println(article.getContent());
            System.out.println();
        }
    }
}
