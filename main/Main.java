package main;

import Utils.Utils;
import java.util.Scanner;
import library.exceptions.BookNotAvaiableException;
import library.exceptions.HasBookException;
import library.models.Book;
import library.models.Reader;
import library.services.Management;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Management management = new Management();
        
        management.readers.add(new Reader("Reader1","reader1@email.com"));
        management.addNewBook(new Book("Book 1", 2020, "Author A"));
        management.addNewBook(new Book("Book 2", 2021, "Author B"));
        
        System.out.println("Welcome to Eddu's Library Management System v0.1");
        int option, adminOption, readerOption;
        while(true){
            option = startMenu(scan);
            boolean run = true;
            switch (option) {
                case 0:
                    System.out.println("System closing, thanks for using...");
                    System.exit(0);
                    break;
                    
                case 1:
                    while(run){
                        adminOption = adminMenu(scan);
                        
                        switch (adminOption) {
                            case 0:
                                System.out.println("Leaving admin role...");
                                run = false;
                                break;
                                
                            case 1:
                                management.showBooks();
                                break;
                                
                            case 2:
                                management.addNewBook(addBook(scan));
                                break;
                                
                            case 3:
                                management.removeBookById(removeBook(scan));
                                break;
                            case 4:
                                management.showReaders();
                                break;
                        }
                    }
                    break;
                    
                case 2:
                    while(run){
                        readerOption = readerMenu(scan);
                        
                        switch (readerOption) {
                            case 0:
                                System.out.println("Leaving reader role...");
                                run = false;
                                break;
                            case 1:
                                management.showBooks();
                                break;
                            case 2:
                                showProfile(management.readers.get(0));
                                break;
                            case 3:
                                borrowBook(scan, management.readers.get(0));
                                break;
                            case 4:
                                returnBorrowedBook(scan, management.readers.get(0));
                                break;
                        }
                    }
                    
                    
                    break;
                    
            }
        }
    }
    
    public static int startMenu(Scanner scan){
        System.out.println("========== MENU ==========");
        System.out.println("1 - Enter as Admin.");
        System.out.println("2 - Enter as Reader.");
        System.out.println("0 - Exit");
        System.out.println("==========================");
        System.out.print("Enter your choice: ");
        return Utils.getIntOption(scan, 2);
    }
    
    public static int adminMenu(Scanner scan){
        System.out.println("========== ADM ==========");
        System.out.println("0 - Exit.");
        System.out.println("1 - Show all books.");
        System.out.println("2 - Add a new book.");
        System.out.println("3 - Remove a book.");
        System.out.println("4 - Show all readers.");
        System.out.println("=========================");
        System.out.print("Enter your choice: ");
        return Utils.getIntOption(scan, 4);
    }
    
    public static int readerMenu(Scanner scan){
        System.out.println("========== READER ==========");
        System.out.println("0 - Exit.");
        System.out.println("1 - Show all books.");
        System.out.println("2 - See profile.");
        System.out.println("3 - Borrow a book.");
        System.out.println("4 - Return book");
        System.out.println("============================");
        return Utils.getIntOption(scan, 4);
    }
    
    public static Book addBook(Scanner scan){
        System.out.println("");
        System.out.print("Book title: ");
        String title = scan.nextLine();
        System.out.print("Book release year: ");
        int releaseYear = Utils.getInt(scan);
        System.out.print("Book author name: ");
        String author = scan.nextLine();
        
        return new Book(title, releaseYear, author);
    }
    
    public static String removeBook(Scanner scan){
        System.out.println("");
        System.out.print("Enter the book id: ");
        String bookId = scan.nextLine();
        return bookId;
    }
    
    public static void showProfile(Reader reader){
        System.out.println("------------------------------------------------------");
        System.out.println(reader.toString());
        System.out.println("------------------------------------------------------");
    }
    
    public static void borrowBook(Scanner scan, Reader reader){
        while (true) {
            try {
                System.out.print("Enter the book id you wanna borrow: ");
                String bookId = scan.nextLine();
                Book book = Management.findBook(bookId);

                if (book == null) {
                    System.out.println("Book with ID " + bookId + " not found, enter again.");
                    continue; 
                }

                reader.borrowBook(book);
                break; 
            } catch (BookNotAvaiableException | HasBookException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
    
    public static void returnBorrowedBook(Scanner scan, Reader reader){
        try {
            reader.returnBook();
        } catch (HasBookException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
