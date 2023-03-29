package org.example;

public class Gamer implements Observer{
    private String name;

    public Gamer(String name) {
        this.name = name;
    }

    public void updateInformation(String gameTitle, String achievements, String briefInfo, String techInfo) {
        System.out.println(this.name + " received update: " + gameTitle + " with achievements: " + achievements);
    }
}
