package com.app.fruits;


public class Fruit {
    private String color;
    private double weight;
    private String name;
    private boolean isFresh;

    // Constructor
    public Fruit(String name, String color, double weight, boolean isFresh) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.isFresh = isFresh;
    }

    // Getters and Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public boolean isFresh() {
        return isFresh;
    }

    public void setFresh(boolean isFresh) {
        this.isFresh = isFresh;
    }

    // Method for taste
    public String taste() {
        return "no specific taste";
    }

    // Overridden toString method
    @Override
    public String toString() {
        return "Fruit [Name=" + name + ", Color=" + color + ", Weight=" + weight + "]";
    }
}
