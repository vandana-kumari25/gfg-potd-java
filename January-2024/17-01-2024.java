/*
Author : Vandana Kumari
Date   : 17/01/2024
Problem : All Unique Permutations of an array
Problem Link: https://www.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1
*/ 

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Taking
        while(t--> 0) {
            int n = Integer.parseInt(br.readLine());
            String str[] = br.readLine().split(" ");

            ArrayList<Integer> arr = new ArrayList<>();

            for(int i=0; i<n; i++) 
                arr.add(Integer.parseInt(str[i]));

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.uniquePerms(arr, n);
            for(int i=0; i<res.size(); i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(res.get(i).get(j)+" ");
                }
                System.out.println();
            }
        }
    }
}


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        ArrayList<Integer> currentPermutation = new ArrayList<>();

        // Sort the input array to ensure unique permutations are in sorted order
        Collections.sort(arr);

        generatePermutations(arr, n, used, currentPermutation, result);

        return result;
    }

    static void generatePermutations(ArrayList<Integer> arr, int n, boolean[] used,
                                      ArrayList<Integer> currentPermutation,
                                      ArrayList<ArrayList<Integer>> result) {
        if (currentPermutation.size() == n) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i] || (i > 0 && arr.get(i).equals(arr.get(i - 1)) && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            currentPermutation.add(arr.get(i));

            generatePermutations(arr, n, used, currentPermutation, result);

            used[i] = false;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}