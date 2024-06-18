/*
Author : Vandana Kumari 
Date : 18/06/2024
Problem : Number of Rectangles in a Circle
Problem Link : https://www.geeksforgeeks.org/problems/rectangles-in-a-circle0457/1
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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int rectanglesInCircle(int r) {
        // code here
        int ans = 0;
        int limit = 2 * r * 2 * r;
        for (int i = 1; i < 2 * r + 1; i++) {
            for (int j = 1; j < 2 * r + 1; j++) {
                if (i * i + j * j <= limit) {
                    ans++;
                }
            }
        }
        return ans;
    }
};