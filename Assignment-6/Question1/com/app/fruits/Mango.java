package com.app.fruits;

public class Mango extends Fruit {
    public Mango(String name, String color, double weight, boolean isFresh) {
        super(name, color, weight, isFresh);
    }

    @Override
    public String taste() {
        return "sweet";
    }
}
