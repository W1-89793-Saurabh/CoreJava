package com.app.fruits;

public class Orange extends Fruit {
    public Orange(String name, String color, double weight, boolean isFresh) {
        super(name, color, weight, isFresh);
    }

    @Override
    public String taste() {
        return "sour";
    }
}
