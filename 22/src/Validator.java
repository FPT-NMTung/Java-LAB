
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {

    private static Scanner sc = new Scanner(System.in);

    public int inputIntValue(String messages) {
        int value = 0;
        boolean flag = false;

        do {
            try {
                System.out.print(messages + ": ");
                value = Integer.parseInt(sc.nextLine());
                flag = true;

            } catch (NumberFormatException e) {
                System.out.println("\tinput not integer format");
            }
        } while (flag != true);

        return value;
    }

    public String inputStringValue(String messages) {
        String value = "";

        System.out.print(messages + ": ");
        value = sc.nextLine();

        return value;
    }
    
    public char inputCharValue(String messages) {
        char value;

        System.out.print(messages + ": ");
        value = sc.nextLine().charAt(0);

        return value;
    }

    public Date inputDateValue(String messages) {
        Date format = null;
        boolean flag = false;

        do {
            System.out.print(messages + ": ");
            String value = sc.nextLine();

            SimpleDateFormat dateF = new SimpleDateFormat("dd-MM-yyy");
            try {

                format = dateF.parse(value);
                flag = true;
            } catch (ParseException e) {
                System.out.println("\tinput not format date");
            }
        } while (flag != true);

        return format;
    }

    public String inputEmailValue(String messages) {
        String value = "";
        String formatEmail = "^[a-zA-Z]{1,}([.][a-zA-Z]{1,})*[@][a-zA-Z]{1,}([.][a-zA-Z]{2,}){1,}$";
        boolean flag = false;
        
        do {            
            System.out.print(messages + ": ");
            value = sc.nextLine();

            if (Pattern.matches(formatEmail, value)) {
                flag = true;
            } else {
                flag = false;
            }
        } while (flag != true);
        
        return value;
    }
}
