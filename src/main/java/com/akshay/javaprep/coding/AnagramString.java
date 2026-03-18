package com.akshay.javaprep.coding;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramString {

    public static void main(String[] args) {
        System.out.println("Enter a String to check it is Anagram or not: ");

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next().toLowerCase();
        String str2 = sc.next().toLowerCase();

        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        if(Arrays.equals(a, b))
            System.out.println("These are Anagram Strings!");
        else
            System.out.println("These are Not a Anagram Strings!");

    }
}
