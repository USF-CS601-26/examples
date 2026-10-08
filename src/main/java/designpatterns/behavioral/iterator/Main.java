package designpatterns.behavioral.iterator;

import java.util.Iterator;

public class Main {
    static void main() {
        CityDirectory directory = new CityDirectory();
        directory.add("SF", "San Francisco");
        directory.add("NY", "New York");

        Iterator<String> it = directory.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Or can use a for-each loop:
        for (String city : directory) {
            System.out.println(city);
        }
    }
}
