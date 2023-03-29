package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameConsole {
    private List<Observer> observers = new ArrayList();
    private String gameTitle;
    private String achievements;
    private String briefInfo;
    private String techInfo;

    GameConsole() {
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {

        for (Observer observer : this.observers) {
            observer.updateInformation(this.gameTitle, this.achievements, this.briefInfo, this.techInfo);
        }

    }

    public void setNewGame(String gameTitle, String achievements, String briefInfo, String techInfo) {
        this.gameTitle = gameTitle;
        this.achievements = achievements;
        this.briefInfo = briefInfo;
        this.techInfo = techInfo;
        this.notifyObservers();
    }
}
