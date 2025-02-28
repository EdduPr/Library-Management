package library.models;

import Utils.Utils;

public class Admin extends User{
    
    private static int count = 0;
    private String id;
    
    public Admin(String name, String email) {
        super(name, email);
        this.id = Utils.generateId('A',count);
    }

    public String getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Admin ID: " + getId() + "\n" +
               "Name: " + getName() + "\n" +
               "Email: " + getEmail();
    }

}
