package datastructures;

import java.util.HashMap;

// An example showing how to work with basic maps (dictionaries) in Java
public class HashMapExample {
    static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();

        // Map each key (the name of the person) to the corresponding value (their score on the assignment)
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Carol", 95);

        // Get a value using a key
        System.out.println(scores.get("Bob"));   // will print 85

        System.out.println(scores.containsKey("Alice"));  // true

        // Replace the value, given the key
        scores.put("Bob", 88);

        // Remove an entry given the key
        scores.remove("Carol");

        System.out.println(scores);
    }
}
