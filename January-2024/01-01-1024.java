/*
    Author : Vandana Kumari
    Date : 01/01/2024
    Problem : Array Pair Sum Divisibility Problem
    Problem Link: https://www.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1
    
 */






//Driver code 
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for(int i=0; i<n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            boolean ans = obj.canPair(nums, k);
            if(ans) 
                System.out.println("True");
            else 
                System.out.println("False");
        }
    }
}

// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        if (nums.length % 2 != 0) {
            // If the array length is odd, it is not possible to form pairs
            return false;
        }

        Map<Integer, Integer> remainderCount = new HashMap<>();

        // Count the occurrences of each remainder when divided by k
        for (int num : nums) {
            int remainder = (num % k + k) % k; // Handle negative numbers
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        // Check if each remainder has a valid pair
        for (int remainder : remainderCount.keySet()) {
            if (remainder == 0) {
                // For remainder 0, the count must be even
                if (remainderCount.get(remainder) % 2 != 0) {
                    return false;
                }
            } else {
                // For other remainders, there must be a corresponding remainder to form pairs
                int complement = k - remainder;
                if (!remainderCount.containsKey(complement) || remainderCount.get(remainder) != remainderCount.get(complement)) {
                    return false;
                }
            }
        }

        return true;
    }
}