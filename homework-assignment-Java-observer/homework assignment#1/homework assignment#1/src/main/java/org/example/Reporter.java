package org.example;

public class Reporter implements Observer {
    private String name;

    public Reporter(String name) {
        this.name = name;
    }

    public void updateInformation(String gameTitle, String achievements, String briefInfo, String techInfo) {
        System.out.println(this.name + " received update: " + gameTitle + " - " + briefInfo);
    }
}
