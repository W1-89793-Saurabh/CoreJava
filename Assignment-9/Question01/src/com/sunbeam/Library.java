package com.sunbeam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Objects;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// Enum for book categories
enum BookCategory {
    FICTION, NON_FICTION, SCIENCE_FICTION, FANTASY, MYSTERY, THRILLER, ROMANCE, BIOGRAPHY, HISTORY, SELF_HELP
}

// Book class
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

    // Getters
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
    

    // Override equals and hashCode based on ISBN (unique ID)
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
        HashSet<Book> library = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        // Accept at least 5 book details
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Book " + (i + 1) + ":");

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            
             //Check for duplicate ISBN before adding
             boolean isbnExists = false;
            for (Book existingBook : library) {
                if (existingBook.getIsbn().equals(isbn)) {
                    System.out.println("Error: ISBN already exists. Please enter a unique ISBN.");
                    isbnExists = true;
                    i--; // Decrement i to re-enter the current book
                    break;  // Exit the inner loop
                }
            }
            if (isbnExists) {
                 continue; //skip to the next iteration of the for loop
            }

            System.out.print("Category (FICTION, NON_FICTION, SCIENCE_FICTION, FANTASY, MYSTERY, THRILLER, ROMANCE, BIOGRAPHY, HISTORY, SELF_HELP): ");
            BookCategory category = null;
            try {
                category = BookCategory.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category.  Setting to FICTION.");
                category = BookCategory.FICTION;
            }


            System.out.print("Price: ");
            double price = -1;  // Initialize to an invalid value
            while (price < 0) {  // Keep asking until a valid price is entered
              try {
                 price = Double.parseDouble(scanner.nextLine());
                 if(price < 0){
                    System.out.println("Price cannot be negative. Please enter a valid price:");
                 }
              } catch (NumberFormatException e) {
                  System.out.println("Invalid price format. Please enter a valid number:");
              }
            }


            System.out.print("Publish Date (YYYY-MM-DD): ");
            LocalDate publishDate = null;
            while(publishDate == null){
                try {
                    publishDate = LocalDate.parse(scanner.nextLine());
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format:");
                }
            }

            System.out.print("Author Name: ");
            String authorName = scanner.nextLine();

            System.out.print("Quantity: ");
             int quantity = -1;
            while (quantity < 0) {
               try {
                    quantity = Integer.parseInt(scanner.nextLine());
                    if(quantity < 0){
                        System.out.println("Quantity cannot be negative. Please enter a valid quantity");
                    }
               } catch (NumberFormatException e) {
                   System.out.println("Invalid quantity format. Please enter a valid integer:");
               }
            }
           


            Book book = new Book(isbn, category, price, publishDate, authorName, quantity);
            library.add(book);
        }

        // Display book details
        System.out.println("\nLibrary Books:");
//        for (Book book : library) {
//            System.out.println(book);
//        }

        //Using an Iterator (alternative way to iterate)
         Iterator<Book> iterator = library.iterator();
         while (iterator.hasNext()) {
            System.out.println(iterator.next());
         }


        scanner.close();
    }
}