/*
Author : Vandana Kumari 
Date : 12/05/2024
Problem : Minimum steps to destination
Problem Link : https://www.geeksforgeeks.org/problems/minimum-number-of-steps-to-reach-a-given-number5234/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int d = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minSteps(d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minSteps(int d) {
        // code here
        if (d == 0)
            return 0;
        int sum = 0;
        int move = 1;
        while (sum < d || (sum - d) % 2 != 0) {
            sum += move;
            move++;
        }
        return move - 1;
    }
}