package designpatterns.behavioral.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class CityDirectory implements Iterable<String> {
    private Map<String, String> cities = new HashMap<>();

    public void add(String code, String city) {
        cities.put(code, city);
    }

    @Override
    public Iterator<String> iterator() {
        return cities.values().iterator();
    }
}