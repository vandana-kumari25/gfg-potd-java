/*
Author : Vandana Kumari
Date   : 19/01/2024
Problem : Top k numbers in a stream
Problem Link: https://www.geeksforgeeks.org/problems/top-k-numbers3425/1
*/ 

import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        return a;
    }

    public static void print(int[] a) {
        for(int e : a) 
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for(int e : a) 
            System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix 
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i=0; i<n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j=0; j<s.length; j++) 
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for(var a : m) {
            for(int e : a) 
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for(var a : m) {
            for(int e : a) 
            System.out.print(e + " ");
        System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t--> 0) {
            String St[] = br.readLine().split(" ");
            int n = Integer.parseInt(St[0]);
            int m = Integer.parseInt(St[1]);

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.kTop(arr, n, m);

            IntMatrix.print(res);
        }
    }
}


class Solution {
    
    // Function to determine the top K elements based on frequency at each iteration
    
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        // Resultant array of arrays to store the top K elements at each iteration
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Array to maintain the current top K elements along with an extra slot
        int[] jada = new int[K + 1];

        // HashMap to store the frequency of each element
        HashMap<Integer, Integer> m = new HashMap<>();

        // Initializing the frequency map with zeros for each element from 0 to K
        for (int i = 0; i <= K; i++) {
            m.put(i, 0);
        }

        // Iterating over the input array
        for (int i = 0; i < arr.length; i++) {
            // Update the last slot of jada with the current element
            jada[K] = arr[i];

            // Updating the frequency map for the current element
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            } else {
                m.put(arr[i], 1);
            }

            // Finding the position of the current element in jada
            int in = -1;
            for (int j = 0; j < jada.length; j++) {
                if (jada[j] == arr[i]) {
                    in = j;
                    break;
                }
            }
            in--;

            // Moving the current element to its correct position in jada based on frequency
            while (in >= 0) {
                if (m.get(jada[in]) < m.get(jada[in + 1])) {
                    int t = jada[in];
                    jada[in] = jada[in + 1];
                    jada[in + 1] = t;
                } else if ((jada[in] > jada[in + 1]) && (m.get(jada[in]) == m.get(jada[in + 1]))) {
                    int t = jada[in];
                    jada[in] = jada[in + 1];
                    jada[in + 1] = t;
                } else {
                    break;
                }
                in--;
            }

            // Populating the current array with the top K elements and add it to the result
            ArrayList<Integer> aa = new ArrayList<>();
            for (int e = 0; e < K && jada[e] != 0; e++) {
                aa.add(jada[e]);
            }
            result.add(aa);
        }

        // Returning the final result
        return result;
    }
}