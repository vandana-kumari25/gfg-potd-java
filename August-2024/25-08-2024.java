/*
Author : Vandana Kumari 
Date : 25/08/2024
Problem : Number of pairs
Problem Link : https://www.geeksforgeeks.org/problems/number-of-pairs-1587115620/1
*/



//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        // code here
        int[] NoOfY = new int[5];
        for (int i = 0; i < N; i++) {
            if (y[i] < 5) NoOfY[y[i]]++;
        }
        Arrays.sort(y);
        long total_pairs = 0;

        for (int a : x) {
            if (a == 0) continue;
            if (a == 1) {
                total_pairs += NoOfY[0];
                continue;
            }

            int idx = Arrays.binarySearch(y, a);
            if (idx < 0) idx = -idx - 1;
            else while (idx < N && y[idx] == a) idx++;
            
            long count = N - idx;
            count += (NoOfY[0] + NoOfY[1]);

            if (a == 2) count -= (NoOfY[3] + NoOfY[4]);
            if (a == 3) count += NoOfY[2];

            total_pairs += count;
        }

        return total_pairs;
    }
}