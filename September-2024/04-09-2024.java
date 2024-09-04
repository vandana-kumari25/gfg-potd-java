/*
Author : Vandana Kumari 
Date : 04/09/2024
Problem : Count ways to N'th Stair(Order does not matter)
Problem Link : https://www.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter5639/1
*/

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int nthStair(int n) {
        // Code here
        if (n == 0) return 1;
        if (n == 1) return 1;
        long prev2 = 1;
        long prev1 = 1;
        long current = 1;
        
        for (int i = 2; i <= n; i++) {
            current = prev2 + 1;
            prev2 = prev1;
            prev1 = current;
        }
        
        return (int)current;
    }
}