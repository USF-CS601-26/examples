package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lookarounds {
    static void main() {
        // Check if a string has :
        // A digit
        // An uppercase letter
        // A special character
        Pattern p = Pattern.compile("(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%]).*");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a valid username that contains a digit, an uppercase letter and a special letter: ");
        String username = s.nextLine();
        Matcher m = p.matcher(username);
        if (m.matches()) {
            System.out.println("Valid username");
        }
        else {
            System.out.println("Invalid username");
        }

    }
}
