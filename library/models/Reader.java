package library.models;

import Utils.Utils;
import java.util.ArrayList;
import library.exceptions.BookNotAvaiableException;
import library.exceptions.HasBookException;

public class Reader extends User{
    private final String id;
    private static int count = 0;
    private Book actualBook;
    private ArrayList<Book> bookHistory;
    
    public Reader(String name, String email) {
        super(name, email);
        count++;
        this.id = Utils.generateId('R',count);
        this.actualBook = null;
        this.bookHistory = new ArrayList<Book>();
    }

    public String getId() {
        return id;
    }

    public Book getActualBook() {
        return actualBook;
    }

    public void setActualBook(Book actualBook) {
        this.actualBook = actualBook;
    }

    public ArrayList<String> getBookHistory() {
        ArrayList<String> titles = new ArrayList<>();
        for (Book book : bookHistory) {
            titles.add(book.getTitle());
        }
        return titles;
    }

    public void setBookHistory(ArrayList<Book> bookHistory){
        this.bookHistory = bookHistory;
    }
    
    public void borrowBook(Book book) throws HasBookException, BookNotAvaiableException {
        
        if(getActualBook() != null){
            throw new HasBookException("You already have a borrowed book, return it first so you can get another one.");
        }
        if(!book.isAvaiable()){
            throw new BookNotAvaiableException("The book you're trying to borrow, isn't avaiable at the moment.");
        }
        
        setActualBook(book);
        this.bookHistory.add(book);
        getActualBook().setAvaiable(false);
        System.out.println("Book: " + book.getTitle() + " borrowed successfully.");
    }
    
    public void returnBook() throws HasBookException{
        if(getActualBook() != null){
            System.out.println("Book: " + getActualBook().getTitle() + " returned successfully.");
            getActualBook().setAvaiable(true);
            setActualBook(null);
        }else{
            throw new HasBookException("You don't have a book borrowed.");
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reader ID: ").append(id).append("\n");
        sb.append("Name: ").append(getName()).append("\n");
        sb.append("Email: ").append(getEmail()).append("\n");

        if (getActualBook() != null) {
            sb.append("Currently Borrowed Book: ").append(getActualBook().getTitle()).append("\n");
        } else {
            sb.append("No books currently borrowed.\n");
        }

        sb.append("Book History: ");
        if (bookHistory.isEmpty()) {
            sb.append("No books borrowed yet.");
        } else {
            sb.append(String.join(", ", getBookHistory()));
        }

        return sb.toString();
    }
    
}
