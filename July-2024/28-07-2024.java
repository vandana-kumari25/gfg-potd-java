/*
Author : Vandana Kumari 
Date : 28/07/2024
Problem : Remove Duplicates
Problem Link : https://www.geeksforgeeks.org/problems/remove-duplicates3034/1
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
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String removeDups(String str) {
        // code here
        int[] fre = new int[26]; 
        StringBuilder result = new StringBuilder(); 
        
        for (char c : str.toCharArray()) {
            if (fre[c - 'a'] == 0) { 
                result.append(c); 
                fre[c - 'a'] = 1; 
            }
        }
        
        return result.toString();
    }
}