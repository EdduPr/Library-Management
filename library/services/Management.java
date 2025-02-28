package library.services;

import Utils.Utils;
import java.util.ArrayList;
import java.util.Scanner;
import library.models.Admin;
import library.models.Book;
import library.models.Reader;

public class Management {
    public static ArrayList<Book> books = new ArrayList<>();
    public ArrayList<Reader> readers = new ArrayList<>();
    public ArrayList<Admin> admins = new ArrayList<>();

    public void showBooks(){
        
        if(books.isEmpty()){
            System.out.println("No books avaiable yet.");
        }else{
            for (int i = 0; i < books.size(); i++) {
                System.out.println("------------------------------------------------------");
                System.out.println(books.get(i).toString());
            }
            System.out.println("------------------------------------------------------");
        }
        
    }
    
    public void addNewBook(Book book){
        books.add(book);
        System.out.println("Book: " + book.getTitle() + " added succssessfully.\n");
        
    }
    
    public static Book findBook(String id){
        Book bookToRemove = null;
        for(Book book : books){
            if(book.getId().equalsIgnoreCase(id)){
                bookToRemove = book;
                break;
            }
        }
        return bookToRemove;
    }
    
    public void removeBookById(String id){
        Book bookToRemove = findBook(id);
        if(bookToRemove== null){
            System.out.println("Book not found.");
            return;
        }
        books.remove(bookToRemove);
        System.out.println("Book: " + bookToRemove.getTitle() + " removed successfully.\n");
    }
    
    public void showReaders(){
        for (Reader reader : readers) {
            System.out.println("------------------------------------------------------");
            System.out.println(reader.toString());
        }
        System.out.println("------------------------------------------------------");
    }
    
    
}
