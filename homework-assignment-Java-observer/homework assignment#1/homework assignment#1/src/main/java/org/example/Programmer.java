package org.example;

public class Programmer implements Observer {
    private String name;

    public Programmer(String name) {
        this.name = name;
    }

    public void updateInformation(String gameTitle, String achievements, String briefInfo, String techInfo) {
        System.out.println(this.name + " received update: " + gameTitle + " with technical data: " + techInfo);
    }
}
