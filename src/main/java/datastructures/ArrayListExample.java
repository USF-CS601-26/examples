package datastructures;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
   static void main(String[] args) {
        List<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("China");
        countries.add("Italy");

        System.out.println(countries);

        for (int i = 0; i < countries.size(); i++) {
            System.out.print(countries.get(i) + " ");
        }
        System.out.println();

        for (String country: countries) {
            System.out.println(country);
        }

        countries.forEach(System.out::println); // Will discuss later


    }
}
