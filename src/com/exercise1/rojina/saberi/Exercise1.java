
package com.exercise1.rojina.saberi;

import java.util.Scanner;

public class Exercise1 {

    // This method prints the increasing part of the pattern
    //  *, **, ***, ****
    public static void printUp(int n) {

        // stop when n reaches 0
        if (n == 0) return;

        // first go to smaller value- ensures stars print from smallest to largest
        printUp(n - 1);

        // Print n stars on the same line
        for (int i = 0; i < n; i++)
            System.out.print("*");

        // Move to next line
        System.out.println();
    }

    // This method prints the decreasing part of the pattern
    // ***, **, *
    public static void printDown(int n) {

        // stop when n reaches 0
        if (n == 0) return;

        // Print n stars
        for (int i = 0; i < n; i++)
            System.out.print("*");

        System.out.println();

        // call to print the next smaller line
        printDown(n - 1);
    }

    public static void main(String[] args) {

        // Rojina Saberi
        // Student Number: 301533334

        Scanner sc = new Scanner(System.in);

        // Ask user for maximum number of stars
        System.out.print("Enter max number of stars: ");
        int n = sc.nextInt();

        // print increasing pattern
        printUp(n);

        // print decreasing pattern
        printDown(n - 1);

        sc.close();
    }
}
