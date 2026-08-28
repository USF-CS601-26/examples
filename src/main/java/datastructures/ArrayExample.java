package datastructures;

import java.util.Arrays;

public class ArrayExample {
    public static void createIntArray() {
        int[] arr; // declare the array arr
        arr = new int[3]; // allocate memory
        arr[0] = 5;
        arr[1] = 3;
        arr[2] = 1;
        // int[] arr = {5, 3, 1}; // using the initializer list

        // Iterate using indices
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

        System.out.println();
        // Iterate using a for each loop
       for (int elem: arr)
            System.out.println(elem);

       Arrays.sort(arr);
       System.out.println(Arrays.toString(arr));
       //System.out.println(arr);

    }


    static void main(String[] args) {
       createIntArray();
    }
}
