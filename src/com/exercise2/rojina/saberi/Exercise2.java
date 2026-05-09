/*
 * lab 3 ex 2
 * this file counts vowels from a string the user enters
 * isvowel is just the helper so the check is in one place
 * recursion is used because i keep checking one char then send the smaller string again
 * main is only for input and printing the final answer
 */
package com.exercise2.rojina.saberi;

import java.util.Scanner;

public class Exercise2 {

    // helper method to check if a character is a vowel
    public static boolean isVowel(char c) {

        // convert character to lowercase
        c = Character.toLowerCase(c);

        // Return true if character is a vowel
        return (c == 'a' || c == 'e' || c == 'i' ||
                c == 'o' || c == 'u');
    }

    // recursive method that counts vowels in a string
    public static int countVowels(String s) {

        //if string is empty, return 0
        if (s.length() == 0) {
            return 0;
        }

        // get the first character of the string
        char first = s.charAt(0);

        // if the first character is a vowel
        if (isVowel(first)) {

            // count 1 vowel and continue with rest of string
            //one character at a time and reduces the string
            return 1 + countVowels(s.substring(1));
        }
        else {

            // if not vowel, just continue the loop
            return countVowels(s.substring(1));
        }
    }

    public static void main(String[] args) {

        // Student Number: 301533334
        // Full Name: Rojina Saberi

        Scanner sc = new Scanner(System.in);

        // user to enter a string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // call loop function
        int result = countVowels(input);

        // Display result
        System.out.println("Number of vowels: " + result);

        sc.close();
    }
}
