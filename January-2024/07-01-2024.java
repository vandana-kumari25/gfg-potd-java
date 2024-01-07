/*
    Author : Vandana Kumari
    Date   : 07/01/2024
    Problem : Split Array Largest Sum
    Problem Link: https://www.geeksforgeeks.org/problems/split-array-largest-sum--141634/1
    
 */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String St[] = br.readLine().split(" ");

            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);

            String S[] = br.readLine().split(" ");

            int[] arr = new int[N];

            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.splitArray(arr, N, K));
        }
    }
}



class Solution {
    public static int splitArray(int[] arr, int N, int K) {
        int low = Arrays.stream(arr).max().getAsInt(); // Minimum possible maximum subarray sum
        int high = Arrays.stream(arr).sum(); // Maximum possible maximum subarray sum

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isValid(arr, N, K, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean isValid(int[] arr, int N, int K, int mid) {
        int count = 1;
        int sum = 0;

        for (int num : arr) {
            sum += num;

            if (sum > mid) {
                count++;
                sum = num;
            }
        }

        return count <= K;
    }
}