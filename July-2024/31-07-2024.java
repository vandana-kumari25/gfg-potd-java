/*
Author : Vandana Kumari 
Date : 31/07/2024
Problem : Longest Common Prefix of Strings
Problem Link : https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        if (arr.length == 0) return "-1";
        String prefix = arr[0];

        for (int i = 1; i < arr.length; ++i) {
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "-1";
            }
        }
        return prefix.isEmpty() ? "-1" : prefix;
    }
}