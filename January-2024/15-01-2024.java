/*
Author : Vandana Kumari
Date   : 15/01/2024
Problem : Grinding Geek
Problem Link: https://www.geeksforgeeks.org/problems/grinding-geek/1
*/ 


import java.util.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int total = sc.nextInt();
            int[] cost = new int[n];
            for(int i=0; i<n; i++) {
                cost[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int result = obj.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

//User function Template for Java
class Solution {
    public int max_courses(int n, int total, int[] cost) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= total; j++) {
                row.add(-1);
            }
            dp.add(row);
        }
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j <= total; j++) {
                if (i == n || j == 0) {
                    dp.get(i).set(j, 0);
                } else {
                    dp.get(i).set(j, dp.get(i + 1).get(j));
                    if (j >= cost[i]) {
                        dp.get(i).set(j, Math.max(dp.get(i).get(j), 1 + dp.get(i + 1).get(j - cost[i] + (9 * cost[i] / 10))));
                    }
                }
            }
        }
        return dp.get(0).get(total);
    }
}