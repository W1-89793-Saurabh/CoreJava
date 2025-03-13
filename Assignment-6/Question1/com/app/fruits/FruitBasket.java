package com.app.fruits;

import java.util.Scanner;
public class FruitBasket {
	private Fruit[] basket; // Array to hold fruits
    private int counter;    // To track the number of fruits added
    private Scanner scanner;

    // Constructor
    public FruitBasket(int size) {
        this.basket = new Fruit[size];
        this.counter = 0;
        this.scanner = new Scanner(System.in);
    }
 // Method to display the menu

    private int displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Mango");
        System.out.println("2. Add Orange");
        System.out.println("3. Add Apple");
        System.out.println("4. Display names of all fruits");
        System.out.println("5. Display details of all fresh fruits");
        System.out.println("6. Display tastes of all stale fruits");
        System.out.println("7. Mark a fruit as stale");
        System.out.println("8. Mark all sour fruits as stale");
        System.out.println("9. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        return choice; // Map choice to MenuOption
    }

    // Method to add a Mango
    private void addMango() {
        if (counter < basket.length) {
            System.out.print("Enter weight: ");
            double weight = scanner.nextDouble();
            System.out.print("Enter color: ");
            String color = scanner.next();
            basket[counter++] = new Mango("Mango", color, weight, true);
            System.out.println("Mango added.");
        } else {
            System.out.println("Basket is full.");
        }
    }

    // Method to add an Orange
    private void addOrange() {
        if (counter < basket.length) {
            System.out.print("Enter weight: ");
            double weight = scanner.nextDouble();
            System.out.print("Enter color: ");
            String color = scanner.next();
            basket[counter++] = new Orange("Orange", color, weight, true);
            System.out.println("Orange added.");
        } else {
            System.out.println("Basket is full.");
        }
    }

    // Method to add an Apple
    private void addApple() {
        if (counter < basket.length) {
            System.out.print("Enter weight: ");
            double weight = scanner.nextDouble();
            System.out.print("Enter color: ");
            String color = scanner.next();
            basket[counter++] = new Apple("Apple", color, weight, true);
            System.out.println("Apple added.");
        } else {
            System.out.println("Basket is full.");
        }
    }

    // Method to display names of all fruits
    private void displayFruitNames() {
        System.out.println("Names of all fruits in the basket:");
        for (Fruit fruit : basket) {
            if (fruit != null) {
                System.out.println(fruit.getName());
            }
        }
    }

    // Method to display details of all fresh fruits
    private void displayFreshFruits() {
        System.out.println("Details of all fresh fruits:");
        for (Fruit fruit : basket) {
            if (fruit != null && fruit.isFresh()) {
                System.out.println(fruit + ", Taste: " + fruit.taste());
            }
        }
    }

    // Method to display tastes of all stale fruits
    private void displayStaleFruits() {
        System.out.println("Tastes of all stale fruits:");
        for (Fruit fruit : basket) {
            if (fruit != null && !fruit.isFresh()) {
                System.out.println(fruit.taste());
            }
        }
    }

    // Method to mark a fruit as stale
    private void markFruitAsStale() {
        System.out.print("Enter the index of the fruit to mark as stale: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < basket.length && basket[index] != null) {
            basket[index].setFresh(false);
            System.out.println("Fruit marked as stale.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to mark all sour fruits as stale
    private void markSourFruitsAsStale() {
        for (Fruit fruit : basket) {
            if (fruit != null && fruit.taste().equals("sour")) {
                fruit.setFresh(false);
            }
        }
        System.out.println("All sour fruits marked as stale.");
    }

    // Main application logic
    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addMango();
                    break;
                case 2:
                    addOrange();
                    break;
                case 3:
                    addApple();
                    break;
                case 4:
                    displayFruitNames();
                    break;
                case 5:
                    displayFreshFruits();
                    break;
                case 6:
                    displayStaleFruits();
                    break;
                case 7:
                    markFruitAsStale();
                    break;
                case 8:
                    markSourFruitsAsStale();
                    break;
                case 9:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the basket size: ");
        int size = scanner.nextInt();
        FruitBasket fruitBasket = new FruitBasket(size);
        fruitBasket.run();
        scanner.close();
	}

}
