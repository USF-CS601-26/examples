package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovingConsonants {
    static void main(String[] args) {
        System.out.println(moveConsonantsFromFrontToEnd("string"));
    }

    public static String moveConsonantsFromFrontToEnd(String word) {
        Pattern p = Pattern.compile("(([^aeiou]*)(.*))");
        Matcher m = p.matcher(word);
        if (m.matches()) {
            System.out.println("group 0 = " + m.group(0));
            System.out.println("group 1 = " + m.group(1));

            return m.group(2) + m.group(1);
        }
        System.out.println("No pattern found");
        return word;
    }
}
