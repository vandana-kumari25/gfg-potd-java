/*
Author : Vandana Kumari 
Date : 26/04/2024
Problem : Exit Point in a Matrix
Problem Link : https://www.geeksforgeeks.org/problems/exit-point-in-a-matrix0905/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        int[] exitPoint = new int[2];
        int direction = 0; 
        int row = 0, col = 0;

        while (true) {
            if (matrix[row][col] == 1) {
                matrix[row][col] = 0;
                direction = (direction + 1) % 4;
            }
            if (direction == 0) col++;
            else if (direction == 1) row++;
            else if (direction == 2) col--;
            else row--;
            if (row < 0 || row >= n || col < 0 || col >= m) {
                exitPoint[0] = row < 0 ? 0 : (row >= n ? n - 1 : row);
                exitPoint[1] = col < 0 ? 0 : (col >= m ? m - 1 : col);
                break;
            }
        }
        return exitPoint;
    }
}
