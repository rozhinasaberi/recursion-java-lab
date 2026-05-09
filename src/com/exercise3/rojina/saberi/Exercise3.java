/*
 * lab 3 ex 3
 * this file is for recursive file searching
 * findbyname starts the work and search is the helper that keeps visiting folders
 * recursion is used because folders can have folders inside folders so it keeps going down
 * main asks for path and file name then prints all matches
 */
package com.exercise3.rojina.saberi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise3 {

    // statring the search
    public static List<String> findByName(String path, String filename) {

        // list to store matching file paths
        List<String> results = new ArrayList<>();

        // create File object root
        File root = new File(path);

        // if path does not exist  then return empty result
        if (!root.exists()) {
            return results;
        }

        // start searching
        search(root, filename, results);

        return results;
    }

    //  helper method
    private static void search(File current, String filename, List<String> results) {

        // Safety check
        if (current == null) return;

        // If current file name matches target filename
        if (current.getName().equals(filename)) {

            // Add the full path of the match
            results.add(current.getAbsolutePath());
        }

        // If current object is a directory
        if (current.isDirectory()) {

            // Get all files/folders inside directory
            File[] children = current.listFiles();

            // Sometimes directories cannot be accessed
            if (children == null) return;

            // Check each file/folder inside directory
            for (File child : children) {

                // loop back and call search again for each child
                //recursion happening
                search(child, filename, results);
            }
        }
    }

    public static void main(String[] args) {

        // Student Number: 301533334
        // Full Name: Rojina Saberi

        Scanner sc = new Scanner(System.in);

        // Ask user for starting folder
        System.out.print("Enter a starting path (example: /Users/yourname/Documents): ");
        String path = sc.nextLine();

        // Ask user for filename to search
        System.out.print("Enter the filename to search for (example: notes.txt): ");
        String filename = sc.nextLine();

        // Start search
        List<String> matches = findByName(path, filename);

        // Display results
        System.out.println("\nMatches found: " + matches.size());

        for (String m : matches) {
            System.out.println(m);
        }

        sc.close();
    }
}
