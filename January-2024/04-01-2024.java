/*
    Author : Vandana Kumari
    Date : 04/01/2024
    Problem : Find element occuring once when all other are present thrice
    Problem Link: https://www.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1
    
 */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {
            int N = Integer.parseInt(br.readLine());

            String S[] = br.readLine().split(" ");

            int[] arr = new int[N];

            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.singleElement(arr, N));
        }
    }
}

class Solution {
    static int singleElement(int[] arr, int N) {
        int result = 0;

        // Iterate through each bit position
        for (int i = 0; i < 32; i++) {
            int sum = 0; // Count of set bits at the current position

            // Count set bits for all elements
            for (int j = 0; j < N; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    sum++;
                }
            }

            // If the sum is not a multiple of 3, set the corresponding bit in the result
            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
}