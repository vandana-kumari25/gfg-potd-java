/*
Author : Vandana Kumari 
Date : 09/05/2024
Problem : Divisor Game
Problem Link : https://www.geeksforgeeks.org/problems/divisor-game-1664432414/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            String ans = obj.divisorGame(n) ? "True" : "False";
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean divisorGame(int n) {
        // code here
        return n%2==0;
    }
}

