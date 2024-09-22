/*
Author : Vandana Kumari 
Date : 19/09/2024
Problem : Reverse Words
Problem Link : https://www.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
*/

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        StringBuilder result = new StringBuilder();
        int n = str.length();
        int end = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == '.') {
                result.append(str.substring(i + 1, end + 1)).append(".");
                end = i - 1; 
            }
        }
        result.append(str.substring(0, end + 1));

        return result.toString();
    }
}