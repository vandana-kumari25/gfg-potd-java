/*
Author : Vandana Kumari 
Date : 22/06/2024
Problem : Extract the Number from the String
Problem Link : https://www.geeksforgeeks.org/problems/extract-the-number-from-the-string3428/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        long num = -1;
        long currentNum = 0;
        boolean validNum = true;
        boolean hasDigit = false;

        for (char c : sentence.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                if (c - '0' > 8) {
                    validNum = false;
                }
                currentNum = currentNum * 10 + (c - '0');
            } else {
                if (hasDigit && validNum && currentNum > num) {
                    num = currentNum;
                }
                currentNum = 0;
                validNum = true;
                hasDigit = false;
            }
        }

        if (hasDigit && validNum && currentNum > num) {
            num = currentNum;
        }

        return num;
    }
}