/*
Author : Vandana Kumari 
Date : 25/04/2024
Problem : Maximum sum of hour glass
Problem Link : https://www.geeksforgeeks.org/problems/maximum-sum-of-hour-glass3842/1
*/


//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.findMaxSum(N, M, Mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMaxSum(int n, int m, int mat[][]) {
        // code here
        if(n < 3 || m < 3)
        {
            return -1;
        }
        int sum = Integer.MIN_VALUE;
        for(int i = 0 ; i <= mat.length-3 ; i++)
        {
            for(int j = 0 ; j<= mat[0].length-3 ; j++)
            {
                int s = (mat[i][j]+mat[i][j+1]+mat[i][j+2]+mat[i+1][j+1]+mat[i+2][j]+mat[i+2][j+1]+mat[i+2][j+2])%1000000007;
                sum = Math.max(sum,s);
            }
        }
        return sum;
    }
};