/*
Author : Vandana Kumari 
Date : 20/09/2024
Problem : Facing the sun
Problem Link : https://www.geeksforgeeks.org/problems/facing-the-sun2126/1
*/

//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputStrings = input.split(" ");
            int[] height = new int[inputStrings.length];
            for (int i = 0; i < inputStrings.length; i++) {
                height[i] = Integer.parseInt(inputStrings[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countBuildings(height);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Returns count buildings that can see sunlight
    public int countBuildings(int[] height) {
        // code here
        int count = 0;
        int max_height = Integer.MIN_VALUE;

        for (int h : height) {
            if (h > max_height) {
                count++;
                max_height = h; 
            }
        }
        return count;
    }
}