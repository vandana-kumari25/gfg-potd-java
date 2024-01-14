/*
Author : Vandana Kumari
Date   : 14/01/2024
Problem : Find duplicate rows in a binary matrix
Problem Link: https://www.geeksforgeeks.org/problems/find-duplicate-rows-in-a-binary-matrix/1
*/ 

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0)  {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];

            for(int i=0; i<n; i++) {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0;j < m; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }
            ArrayList<Integer> ans = new Solution().repeatedRows(arr, n, m);
            for(int i=0; i<ans.size(); i++) 
                System.out.println(ans.get(i)+" ");

            System.out.println();
        }
    }
}

//User function Template for Java

class Solution {
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<String> seenRows = new HashSet<>();

        for (int i = 0; i < m; i++) {
            StringBuilder rowStringBuilder = new StringBuilder();

            for (int j = 0; j < n; j++) {
                rowStringBuilder.append(matrix[i][j]);
            }

            String rowString = rowStringBuilder.toString();

            if (seenRows.contains(rowString)) {
                // This row is a duplicate
                result.add(i);
            } else {
                seenRows.add(rowString);
            }
        }

        return result;
    }
}
