package com.pluralsight;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create array to hold 20 books
        Book[] books = new Book[20];

        // Initialize books with data
        books[0] = new Book(1, "978-0-06-245773-8", "The Silent Patient");
        books[1] = new Book(2, "978-1-250-30690-5", "The Guest List");
        books[2] = new Book(3, "978-1-5011-5464-5", "The Woman in the Window");
        books[3] = new Book(4, "978-0-525-53529-9", "Gone Girl");
        books[4] = new Book(5, "978-1-250-30691-2", "The Couple Next Door");
        books[5] = new Book(6, "978-0-593-13520-4", "The Last House on Needless Street");
        books[6] = new Book(7, "978-1-250-30692-9", "Behind Closed Doors");
        books[7] = new Book(8, "978-1-250-30693-6", "The Girl on the Train");
        books[8] = new Book(9, "978-1-250-30694-3", "Before I Go to Sleep");
        books[9] = new Book(10, "978-1-250-30695-0", "The Chain");
        books[10] = new Book(11, "978-1-250-30696-7", "The Family Upstairs");
        books[11] = new Book(12, "978-1-250-30697-4", "The Turn of the Key");
        books[12] = new Book(13, "978-1-250-30698-1", "Lock Every Door");
        books[13] = new Book(14, "978-1-250-30699-8", "The Hunting Party");
        books[14] = new Book(15, "978-1-250-30700-1", "The Wife Between Us");
        books[15] = new Book(16, "978-1-250-30701-8", "The Perfect Nanny");
        books[16] = new Book(17, "978-1-250-30702-5", "The Other Woman");
        books[17] = new Book(18, "978-1-250-30703-2", "The 19th Christmas");
        books[18] = new Book(19, "978-1-250-30704-9", "The Snowman");
        books[19] = new Book(20, "978-1-250-30705-6", "The Girl with the Dragon Tattoo");

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the Home Screen
            System.out.println("\nStore Home Screen:");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Process user choice
            switch (choice) {
                case 1:
                    // Show available books
                    System.out.println("\nAvailable Books:");
                    for (Book book : books) {
                        if (!book.isCheckedOut()) {
                            System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
                        }
                    }
                    // Prompt user to check out a book
                    System.out.print("\nEnter the ID of the book to check out (or 0 to go back): ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    if (bookId > 0 && bookId <= books.length && !books[bookId - 1].isCheckedOut()) {
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        books[bookId - 1].checkOut(name);
                        System.out.println("Book checked out successfully!");
                    } else if (bookId != 0) {
                        System.out.println("Invalid book ID or book already checked out.");
                    }
                    break;
                case 2:
                    // Show checked out books
                    System.out.println("\nChecked Out Books:");
                    for (Book book : books) {
                        if (book.isCheckedOut()) {
                            System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Checked Out To: " + book.getCheckedOutTo());
                        }
                    }
                    // Prompt user to check in a book
                    System.out.print("\nEnter 'C' to check in a book or 'X' to go back: ");
                    String checkInOption = scanner.nextLine();
                    if (checkInOption.equalsIgnoreCase("C")) {
                        System.out.print("Enter the ID of the book to check in: ");
                        int checkInId = scanner.nextInt();
                        scanner.nextLine();
                        if (checkInId > 0 && checkInId <= books.length && books[checkInId - 1].isCheckedOut()) {
                            books[checkInId - 1].checkIn();
                            System.out.println("Book checked in successfully!");
                        } else {
                            System.out.println("Invalid book ID or book is not checked out.");
                        }
                    }
                    break;
                case 3:
                    // Exit the program
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}