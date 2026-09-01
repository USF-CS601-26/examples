package datastructures;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    static void main() {
        // HashSet
        Set<String> words = new HashSet<>();
        words.add("cat");
        words.add("mail");
        words.add("dog");
        words.add("cat"); // won't add it again
        System.out.println(words);

        System.out.println(words.contains("cat")); // more efficient than contains in ArrayList

        // TreeSet
        TreeSet<String> wordsTree = new TreeSet<>();
        wordsTree.add("cat");
        wordsTree.add("mail");
        wordsTree.add("dog");
        System.out.println(wordsTree); // will print cat, dog, mail
        String firstElement = wordsTree.first();
        System.out.println(firstElement);
        String largestWordSmallerThan = wordsTree.lower("mail");
        System.out.println(largestWordSmallerThan);
        System.out.println(wordsTree.subSet("fox", "pet"));

    }
}
