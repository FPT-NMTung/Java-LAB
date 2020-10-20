
import java.util.Scanner;

public class Validator {
    public int inputIntValue (String message) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int value = 0;
        
        do {       
            try {             
                System.out.print(message + ": ");
                value = Integer.parseInt(sc.nextLine());
                flag = true;   
            } catch (NumberFormatException e) {
                System.out.println("    number is not integer !");
            }
        } while (flag != true);
    
        return value;
    }
    
    public String inputStringValue (String message) {
        Scanner sc = new Scanner(System.in);
        String value;
        
        System.out.print(message + ": ");
        value = sc.nextLine();
        
        return value;
    }
    
    
}
