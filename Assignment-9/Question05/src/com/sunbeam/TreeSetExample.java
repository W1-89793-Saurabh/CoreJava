package com.sunbeam;

import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetExample {

    public static void main(String[] args) {

        // Create a new TreeSet to store strings (colors)
        TreeSet<String> colorTreeSet = new TreeSet<>();

        // Add some colors to the TreeSet
        colorTreeSet.add("Red");
        colorTreeSet.add("Green");
        colorTreeSet.add("Blue");
        colorTreeSet.add("Yellow");
        colorTreeSet.add("Orange");
        colorTreeSet.add("Purple");
        colorTreeSet.add("Black");
        colorTreeSet.add("White");
        colorTreeSet.add("Green"); // Duplicate - will be ignored

        // Print the TreeSet using different methods:

        // 1. Using the toString() method (implicit iteration)
        System.out.println("TreeSet (using toString()): " + colorTreeSet);

        // 2. Using an enhanced for loop (explicit iteration)
        System.out.println("\nTreeSet (using enhanced for loop):");
        for (String color : colorTreeSet) {
            System.out.println(color);
        }

        // 3. Using an Iterator (explicit iteration)
        System.out.println("\nTreeSet (using Iterator):");
        Iterator<String> iterator = colorTreeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //Demonstrating that duplicate entries are not added
        System.out.println("\nSize of TreeSet after adding duplicates:" + colorTreeSet.size());

    }
}