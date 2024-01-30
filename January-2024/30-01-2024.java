/*
Author : Vandana Kumari
Date   : 30/01/2024
Problem : LCS of three strings
Problem Link: https://www.geeksforgeeks.org/problems/lcs-of-three-strings0028/1
*/


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-->0) {
            String input_Line[] = br.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_Line[0]);
            int n2 = Integer.parseInt(input_Line[1]);
            int n3 = Integer.parseInt(input_Line[2]);

            input_Line = br.readLine().trim().split("\\s+");
            String A = input_Line[0];
            String B = input_Line[1];
            String C = input_Line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    }
}


//User function Template for Java
class Solution{
    int LCSof3(String A, String B, String C, int n1, int n2, int n3){ 
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];
        for(int i = 0; i <= n1; i++) {
            for(int j = 0; j <= n2; j++) {
                for(int k = 0; k <= n3; k++) {
                    if(i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 0;
                    }else if(A.charAt(i - 1) == B.charAt(j - 1) && B.charAt(j - 1) == C.charAt(k - 1)){
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    }else{
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }
        return dp[n1][n2][n3];
    }
}