/*
Author : Vandana Kumari 
Date : 03/03/2024
Problem : Largest Number formed from an Array
Problem Link : https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
*/


//{ Driver Code Starts
    //Initial Template for Java
    
    
    
    import java.util.*;
    import java.io.*;
    
    class Main {
    
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int tc = Integer.parseInt(br.readLine().trim());
            while (tc-- > 0) {
                String[] inputLine;
                int n = Integer.parseInt(br.readLine().trim());
                String[] arr = br.readLine().trim().split(" ");
    
                String ans = new Solution().printLargest(n, arr);
                System.out.println(ans);
            }
        }
    }
    // } Driver Code Ends
    
    
    

//User function Template for Java

class Solution {
    String printLargest(int n, String[] arr) {
        // Custom comparator to compare two strings based on their concatenation
        Comparator<String> customComparator = (s1, s2) -> (s2 + s1).compareTo(s1 + s2);

        // Sort the array of strings using the custom comparator
        Arrays.sort(arr, customComparator);

        // Concatenate the sorted strings to form the largest number
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }
}