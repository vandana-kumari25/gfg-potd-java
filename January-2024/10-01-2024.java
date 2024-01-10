/*
    Author : Vandana Kumari
    Date   : 10/01/2024
    Problem : Longest subarray with sum divisible by K
    Problem Link: https://www.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1
    
 */


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        //looping through all testcases
        while (testcases-- > 0) {
            String line1 = br.readLine();
            String[] element = line1.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            String line = br.readLine();
            String[] elements = line.trim().split("\\s+");

            for(int i=0; i<sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();

            int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}

//User function Template for Java

class Solution {
    int longSubarrWthSumDivByK(int a[], int n, int k) {
        // Complete the function
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];
            int remainder = ((sum % k) + k) % k;

            if (remainder == 0) {
                maxLength = i + 1; // Update maxLength if the subarray ends at index i
            } else if (prefixSumMap.containsKey(remainder)) {
                // If the remainder is seen before, update maxLength
                maxLength = Math.max(maxLength, i - prefixSumMap.get(remainder));
            } else {
                // Store the first occurrence of remainder
                prefixSumMap.put(remainder, i);
            }
        }

        return maxLength;
    }
}