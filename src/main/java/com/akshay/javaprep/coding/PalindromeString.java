package com.akshay.javaprep.coding;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your String to check Palindrome: ");
        String str = sc.next().toLowerCase();

        char[] a = str.toCharArray();

        for(int i = 0; i < str.length()/2; i++){
            if(a[i] != a[(str.length() - 1) - i]){
                System.out.println("Not a Palindrome String: " + str);
                return;
            }
        }
        System.out.println("It's a Palindrome String: " + str);

        // Time complexity = O(n)
        // Space complexity = O(n)



        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt((str.length() - 1) - i)){
                System.out.println("Not a Palindrome String: " + str);
                return;
            }
        }
        System.out.println("It's a Palindrome String: " + str);

        // Time complexity = O(n)
        // Space complexity = O(n)

    }
}
