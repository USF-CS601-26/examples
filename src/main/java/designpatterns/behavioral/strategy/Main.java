package designpatterns.behavioral.strategy;

import java.util.Arrays;

public class Main {
    static void main(String[] args) {
        int[] arr = {9, 3, 5, 1, 7};
        Sorter sorter = new Sorter(arr);
        sorter.setSortingStrategy(new MergeSort());
        sorter.sort();

        // sorter.setSortingStrategy((new InsertionSort())); // requires that you write InsertionSort
        //sorter.sort();

        // sorter.setSortingStrategy(array -> Arrays.sort(array));
        // sorter.sort();

        sorter.displayArray();
    }
}
