package com.sunbeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListExamples {

    // Method to find the maximum number in a List of any Number type
    public static <T extends Number & Comparable<T>> T findMax(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null; // Or throw an exception, depending on desired behavior
        }

        T max = list.get(0); // Initialize max with the first element

        for (T number : list) {
            if (number.compareTo(max) > 0) {
                max = number;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // 1. ArrayList
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(5);
        arrayList.add(25);
        arrayList.add(1);
        System.out.println("ArrayList: " + arrayList);
        Integer maxInt = findMax(arrayList);
        System.out.println("Max in ArrayList: " + maxInt);


        // 2. LinkedList
        List<Double> linkedList = new LinkedList<>();
        linkedList.add(3.14);
        linkedList.add(2.71);
        linkedList.add(1.618);
        linkedList.add(5.5);
        System.out.println("LinkedList: " + linkedList);
        Double maxDouble = findMax(linkedList);
        System.out.println("Max in LinkedList: " + maxDouble);


        // 3. Vector (thread-safe, similar to ArrayList)
        List<Long> vectorList = new Vector<>();
        vectorList.add(1000L);
        vectorList.add(500L);
        vectorList.add(2000L);
        System.out.println("Vector: " + vectorList);
        Long maxLong = findMax(vectorList);
        System.out.println("Max in Vector: " + maxLong);

        // 4. List using Arrays.asList (fixed-size)
        List<Float> asList = Arrays.asList(2.5f, 1.2f, 3.8f, 0.5f);
        System.out.println("Arrays.asList: " + asList);
		//Note:  Arrays.asList() returns a fixed-size list. 
		//You can't add or remove elements from this list directly.  
		//If you try to add or remove, it will throw an UnsupportedOperationException.
		//asList.add(4.4);  // This would throw an UnsupportedOperationException
        Float maxFloat = findMax(asList);
        System.out.println("Max in Arrays.asList: " + maxFloat);

        // 5. Creating an ArrayList from an existing array (more flexible than Arrays.asList)
		Integer[] intArray = {42, 15, 99, 23};
		List<Integer> arrayListFromArray = new ArrayList<>(Arrays.asList(intArray));
		arrayListFromArray.add(77); // Now you CAN add elements
		System.out.println("ArrayList from array: " + arrayListFromArray);
        Integer anotherMax = findMax(arrayListFromArray);
        System.out.println("Max in arrayListFromArray: " + anotherMax);

         // 6. Empty List
        List<Integer> emptyList = new ArrayList<>();
        Integer maxEmpty = findMax(emptyList); // Handling the empty list case
        System.out.println("Max in Empty List: " + maxEmpty); // Output: null

        // 7. Null List
        List<Double> nullList = null;
        Double maxNull = findMax(nullList);  // Handling the null list case
        System.out.println("Max in Null List: " + maxNull);  // Output: null
    }
}