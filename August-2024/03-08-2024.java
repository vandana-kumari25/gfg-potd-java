/*
Author : Vandana Kumari 
Date : 03/08/2024
Problem : The Celebrity Problem
Problem Link : https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int potentialCelebrity = 0;
        for (int i = 1; i < n; ++i) {
            if (mat[potentialCelebrity][i] == 1) {
                potentialCelebrity = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (i != potentialCelebrity && (mat[potentialCelebrity][i] == 1 || mat[i][potentialCelebrity] == 0)) {
                return -1;
            }
        }

        return potentialCelebrity;
    }
}