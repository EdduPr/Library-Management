package Utils;

import java.util.Scanner;

public class Utils {
    public static String generateId(char type, int count){
        return String.format("#%c%03d", type, count);
    }
    
    public static int getIntOption(Scanner scan,int limit){
        int option;
        while(true){
            try {
                String enter = scan.nextLine();
                option = Integer.parseInt(enter);
                if(option >= 0 && option <= limit){
                    return option;
                }
                System.out.print("Invalid option, type again: ");
            }catch (NumberFormatException e) {
                System.out.print("invalid option, type again: "); 
            }
        }
    }
    
    public static int getInt(Scanner scan){
        int option = 0;
        while(true){
            try {
                String enter = scan.nextLine();
                option = Integer.parseInt(enter);
                break;
            }catch (NumberFormatException e) {
                System.out.print("Invalid enter, type again: ");
            }
        }
        
        return option;
    }
}
