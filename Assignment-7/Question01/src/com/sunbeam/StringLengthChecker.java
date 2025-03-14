// Define the custom exception
package com.sunbeam;

class ExceptionLineTooLong extends Exception {
    public ExceptionLineTooLong() {
        super("The strings is too long"); // Call the superclass (Exception) constructor with the error message
    }
}


public class StringLengthChecker {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter a string: ");
        String userString = input.nextLine();

        try {
            checkStringLength(userString);
            System.out.println("String length is within the limit."); // Only reached if no exception is thrown
        } catch (ExceptionLineTooLong e) {
            System.out.println("Error: " + e.getMessage()); // Prints the exception's error message
        } finally {
            input.close(); // Good practice to close resources in a 'finally' block
        }
    }

    // Method to check the string length and throw the exception
    public static void checkStringLength(String str) throws ExceptionLineTooLong {
        if (str.length() > 80) {
            throw new ExceptionLineTooLong(); // Throw the custom exception
        }
    }
}