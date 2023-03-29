package org.example;

public class Main {
    public static void main(String[] args) {
        var console = new GameConsole();
        var first_gamer = new Gamer("Gamer-Ivan");
        var second_gamer = new Gamer("Gamer-Kate");

        var first_reporter = new Reporter("Boris-Reporter");
        var second_reporter = new Reporter("Pasha-Reporter 2");

        var first_developer = new Programmer("Developer 1");
        var second_developer2 = new Programmer("Developer 2");

        console.addObserver(first_gamer);
        console.addObserver(second_gamer);

        console.addObserver(first_reporter);
        console.addObserver(second_reporter);

        console.addObserver(first_developer);
        console.addObserver(second_developer2);

        console.setNewGame("First game", "Achievements 1", "Brief info 1", "Technical info 1");
        console.setNewGame("Second game", "Achievements 2", "Brief info 2", "Technical info 2");
    }
}