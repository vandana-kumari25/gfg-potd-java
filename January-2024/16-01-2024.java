/*
Author : Vandana Kumari
Date   : 16/01/2024
Problem : Sequence of Sequence
Problem Link: https://www.geeksforgeeks.org/problems/sequence-of-sequence1155/1
*/ 

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Taking input for

        while(t--> 0) {
            String input_line[] = br.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);

            Solution obj = new Solution();
            System.out.println(obj.numberSequence(m,n));
        }
    }
}


//User function Template for Java

class Solution{
    static int numberSequence(int m, int n){
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < m + 1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0 || i < j) {
                    row.add(0);
                } else if (j == 1) {
                    row.add(i);
                } else {
                    row.add(dp.get(i - 1).get(j) + dp.get(i / 2).get(j - 1));
                }
            }
            dp.add(row);
        }
        return dp.get(m).get(n);
    }
}