/*
Author : Vandana Kumari 
Date : 31/05/2024
Problem : Swap two nibbles in a byte
Problem Link : https://www.geeksforgeeks.org/problems/swap-two-nibbles-in-a-byte0446/1
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
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int swapNibbles(int n) {
        // code here
        int rn = (n & 0xF0) >> 4; 
        int ln = (n & 0x0F) << 4; 
        return rn | ln;
    }
}