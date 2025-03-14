package com.sunbeam;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Objects;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

// Enum for book categories (same as before)
enum BookCategory {
    FICTION, NON_FICTION, SCIENCE_FICTION, FANTASY, MYSTERY, THRILLER, ROMANCE, BIOGRAPHY, HISTORY, SELF_HELP
}

// Book class (same as before)
class Book {
    private String isbn;
    private BookCategory category;
    private double price;
    private LocalDate publishDate;
    private String authorName;
    private int quantity;

    public Book(String isbn, BookCategory category, double price, LocalDate publishDate, String authorName, int quantity) {
        this.isbn = isbn;
        this.category = category;
        this.price = price;
        this.publishDate = publishDate;
        this.authorName = authorName;
        this.quantity = quantity;
    }

    // Getters (same as before)
    public String getIsbn() {
        return isbn;
    }

    public BookCategory getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getQuantity() {
        return quantity;
    }

    // Override equals and hashCode (same as before)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", authorName='" + authorName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

public class Library {
    public static void main(String[] args) {
        HashSet<Book> bookHashSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        // Accept book details (same input validation as before)
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Book " + (i + 1) + ":");

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            // Check for duplicate ISBN
            boolean isbnExists = false;
            for (Book existingBook : bookHashSet) {
                if (existingBook.getIsbn().equals(isbn)) {
                    System.out.println("Error: ISBN already exists. Please enter a unique ISBN.");
                    isbnExists = true;
                    i--;
                    break;
                }
            }
            if (isbnExists) {
                continue;
            }

            System.out.print("Category (FICTION, NON_FICTION, ...): ");
            BookCategory category = null;
            try {
                category = BookCategory.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category. Setting to FICTION.");
                category = BookCategory.FICTION;
            }

            System.out.print("Price: ");
            double price = -1;
            while (price < 0) {
                try {
                    price = Double.parseDouble(scanner.nextLine());
                    if (price < 0) {
                        System.out.println("Price cannot be negative.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price format.");
                }
            }

            System.out.print("Publish Date (YYYY-MM-DD): ");
            LocalDate publishDate = null;
            while (publishDate == null) {
                try {
                    publishDate = LocalDate.parse(scanner.nextLine());
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format.");
                }
            }

            System.out.print("Author Name: ");
            String authorName = scanner.nextLine();

            System.out.print("Quantity: ");
            int quantity = -1;
            while (quantity < 0) {
                try {
                    quantity = Integer.parseInt(scanner.nextLine());
                    if (quantity < 0) {
                        System.out.println("Quantity cannot be negative.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid quantity format.");
                }
            }

            Book book = new Book(isbn, category, price, publishDate, authorName, quantity);
            bookHashSet.add(book);
        }

        // Create a LinkedHashSet and copy elements from HashSet
        LinkedHashSet<Book> bookLinkedHashSet = new LinkedHashSet<>(bookHashSet);

        // Display books from HashSet (no guaranteed order)
        System.out.println("\nBooks from HashSet (no guaranteed order):");
        for (Book book : bookHashSet) {
            System.out.println(book);
        }

        // Display books from LinkedHashSet (insertion order)
        System.out.println("\nBooks from LinkedHashSet (insertion order):");
        for (Book book : bookLinkedHashSet) {
            System.out.println(book);
        }
    }
}