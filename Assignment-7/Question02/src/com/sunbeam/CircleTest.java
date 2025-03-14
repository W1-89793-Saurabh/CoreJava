package com.sunbeam;
import java.util.Scanner;

class NegativeDiameterException extends Exception {
    public NegativeDiameterException(String message) {
        super(message); // Call superclass constructor with the error message
    }
}

class Circle {
    private double myX;         
    private double myY;         
    private double myDiameter;  

    
    public Circle() {
        this.myX = 0;
        this.myY = 0;
        this.myDiameter = 100; 
    }

    public Circle(double x, double y, double diameter) throws NegativeDiameterException {
        if (diameter < 0) {
            throw new NegativeDiameterException("Diameter cannot be negative.");
        }
        this.myX = x;
        this.myY = y;
        this.myDiameter = diameter;
    }

    // Accessor methods (Getters)
    public double getMyX() {
        return myX;
    }

    public double getMyY() {
        return myY;
    }

    public double getMyDiameter() {
        return myDiameter;
    }

    // Mutator methods (Setters)
    public void setMyX(double x) {
        this.myX = x;
    }

    public void setMyY(double y) {
        this.myY = y;
    }

    public void setMyDiameter(double diameter) throws NegativeDiameterException {
        if (diameter < 0) {
            throw new NegativeDiameterException("Diameter cannot be negative.");
        }
        this.myDiameter = diameter;
    }


    @Override
    public String toString() {
        return "Circle [Center=(" + myX + ", " + myY + "), Diameter=" + myDiameter + "]";
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
   
            Circle circle1 = new Circle();
            System.out.println("Default Circle: " + circle1);

            System.out.print("Enter X-coordinate of the center: ");
            double x = scanner.nextDouble();
            System.out.print("Enter Y-coordinate of the center: ");
            double y = scanner.nextDouble();
            System.out.print("Enter the diameter: ");
            double diameter = scanner.nextDouble();

            Circle circle2 = new Circle(x, y, diameter);
            System.out.println("Custom Circle: " + circle2);

        } catch (NegativeDiameterException e) {
            System.out.println(e.getMessage());
        }
    }
}
